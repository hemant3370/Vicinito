package hemant3370.vicinito.com.vicinito.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemant3370.vicinito.com.vicinito.Adapters.CustomItemClickListener;
import hemant3370.vicinito.com.vicinito.Adapters.MatchGridAdapter;
import hemant3370.vicinito.com.vicinito.Applications.Initializer;
import hemant3370.vicinito.com.vicinito.Models.Stream.Stream;
import hemant3370.vicinito.com.vicinito.Models.Stream.User;
import hemant3370.vicinito.com.vicinito.R;
import hemant3370.vicinito.com.vicinito.Retrofit.Client.RestClient;
import hemant3370.vicinito.com.vicinito.Retrofit.Services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.feed_recycler_view)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public CustomItemClickListener listener;
    @BindView(R.id.profile_iv) ImageView profileImageView;
    @BindView(R.id.main_progress) View mProgressView;
    List<Stream> feed = new ArrayList<>();
    @Inject
    Retrofit mRetrofit;
    User user;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        user = getIntent().getParcelableExtra("USER");
        ButterKnife.bind(this);
        ((Initializer) getApplication()).getNetComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (user != null){
            setTitle(user.getName());
            Glide.with(this).load(user.getThumbnail()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(profileImageView);
        }
        getUser();
        final Activity activity = this;


        // use a linear layout manager
        GridLayoutManager mLayoutManager;
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new GridLayoutManager(this, 1);
//            mLayoutManager = new StaggeredGridLayoutManager(2,Configuration.ORIENTATION_PORTRAIT);

        } else {
            mLayoutManager = new GridLayoutManager(this, 2);
//            mLayoutManager = new StaggeredGridLayoutManager(3,Configuration.ORIENTATION_LANDSCAPE);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        listener = new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent detail = new Intent(ProfileActivity.this,DetailActivity.class);
                detail.putExtra("id",feed.get(position).getId());
                startActivity(detail);
            }

            @Override
            public void onItemShare(View v, int position) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, feed.get(position).getTitle());
                sharingIntent.putExtra(android.content.Intent.EXTRA_HTML_TEXT, Html.escapeHtml(feed.get(position).getHtmlDescription()));
                startActivity(Intent.createChooser(sharingIntent,"Share using"));
            }

            @Override
            public void onUserClicked(View v, int position) {

            }
        };

//        mAdapter = new MatchGridAdapter(this,feed,listener);
//        mRecyclerView.setAdapter(mAdapter);
        getUserFeed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void getUser(){

            if (mRetrofit == null){
                mRetrofit = RestClient.getClient();
            }
            apiInterface = mRetrofit.create(ApiInterface.class);
            Call<Stream> call = apiInterface.getUser(user.getId().toString());
            call.enqueue(new Callback<Stream>() {
                @Override
                public void onResponse(Call<Stream> call, Response<Stream> response) {

                    if (response.code() == 200 ){
                        user = response.body().getUser();
                        Glide.with(ProfileActivity.this).load(user.getProfilePic()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(profileImageView);

                    }
                    else {
                        Toast.makeText(ProfileActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<Stream> call, Throwable t) {

                    showProgress(false);
                    Toast.makeText(ProfileActivity.this,t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
    }
    private void getUserFeed() {

        showProgress(true);
        if (mRetrofit == null){
            mRetrofit = RestClient.getClient();
        }
        apiInterface = mRetrofit.create(ApiInterface.class);
        Call<List<Stream>> call = apiInterface.getUserFeed(user.getId().toString());
        call.enqueue(new Callback<List<Stream>>() {
            @Override
            public void onResponse(Call<List<Stream>> call, Response<List<Stream>> response) {

                if (response.code() == 200 ){
                    showProgress(false);
                    for (Stream s :
                            response.body()) {
                        if (s.getTitle() != null && s.getHtmlDescription() != null) {
                            feed.add(s);
                        }
                    }
                    mAdapter = new MatchGridAdapter(ProfileActivity.this,feed,listener);
                    mRecyclerView.setAdapter(mAdapter);
                }
                else {


                    Toast.makeText(ProfileActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Stream>> call, Throwable t) {

                showProgress(false);
                Toast.makeText(ProfileActivity.this,t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
        mRecyclerView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }
}
