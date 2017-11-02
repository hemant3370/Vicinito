package hemant3370.vicinito.com.vicinito.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemant3370.vicinito.com.vicinito.Adapters.CustomItemClickListener;
import hemant3370.vicinito.com.vicinito.Adapters.feedDetailAdapter;
import hemant3370.vicinito.com.vicinito.Applications.Initializer;
import hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail.ItemDetail;
import hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail.Resource;
import hemant3370.vicinito.com.vicinito.R;
import hemant3370.vicinito.com.vicinito.Retrofit.Client.RestClient;
import hemant3370.vicinito.com.vicinito.Retrofit.Services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.feedDetail_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.detailtitle)
    TextView titleTV;
    private RecyclerView.Adapter mAdapter;
    public CustomItemClickListener listener;
    @BindView(R.id.detail_progress) View mProgressView;
    List<Resource> feed = new ArrayList<>();
    @Inject
    Retrofit mRetrofit;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        ((Initializer) getApplication()).getNetComponent().inject(this);
        setTitle("");
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

            }

            @Override
            public void onItemShare(View v, int position) {

            }
        };
        getDetails();
    }

    private void getDetails() {

        showProgress(true);
        if (mRetrofit == null){
            mRetrofit = RestClient.getClient();
        }
        apiInterface = mRetrofit.create(ApiInterface.class);
        Call<ItemDetail> call = apiInterface.getFeedItem(getIntent().getStringExtra("id"));
        call.enqueue(new Callback<ItemDetail>() {
            @Override
            public void onResponse(Call<ItemDetail> call, Response<ItemDetail> response) {

                if (response.code() == 200 ){

                    showProgress(false);
                    feed = response.body().getData().getResources();
                    mAdapter = new feedDetailAdapter(DetailActivity.this,feed,listener);
                    mRecyclerView.setAdapter(mAdapter);
                    titleTV.setText(response.body().getTitle());
                    setTitle(response.body().getTopic().get(0).getName());
                }
                else {
                    Toast.makeText(DetailActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ItemDetail> call, Throwable t) {

                showProgress(false);
                Toast.makeText(DetailActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
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
