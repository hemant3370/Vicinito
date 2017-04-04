package hemant3370.vicinito.com.vicinito.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hemant3370.vicinito.com.vicinito.Adapters.CustomItemClickListener;
import hemant3370.vicinito.com.vicinito.Adapters.TopicsAdapter;
import hemant3370.vicinito.com.vicinito.Applications.Initializer;
import hemant3370.vicinito.com.vicinito.Models.Stream.TopicResponse;
import hemant3370.vicinito.com.vicinito.R;
import hemant3370.vicinito.com.vicinito.Retrofit.Client.RestClient;
import hemant3370.vicinito.com.vicinito.Retrofit.Services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TopicsActivity extends AppCompatActivity {

    @Bind(R.id.topics_recycler_view)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager mLayoutManager;
    public CustomItemClickListener listener;
    @Bind(R.id.topics_progress)
    View mProgressView;
    List<TopicResponse> feed = new ArrayList<>();
    @Inject
    Retrofit mRetrofit;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        ButterKnife.bind(this);
        ((Initializer) getApplication()).getNetComponent().inject(this);

        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        listener = new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("topicId",feed.get(position).getTopicId().toString());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        };

        attemptLogin();
    }

    private void attemptLogin() {

        showProgress(true);
        if (mRetrofit == null){
            mRetrofit = RestClient.getClient();
        }
        apiInterface = mRetrofit.create(ApiInterface.class);
        Call<List<TopicResponse>> call = apiInterface.getTopics();
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {

                if (response.code() == 200 ){

                    showProgress(false);
                    feed = response.body();
                    mAdapter = new TopicsAdapter(TopicsActivity.this,feed,listener);
                    mRecyclerView.setAdapter(mAdapter);

                }
                else {


                    Toast.makeText(TopicsActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<TopicResponse>> call, Throwable t) {

                showProgress(false);
                Toast.makeText(TopicsActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
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
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}
