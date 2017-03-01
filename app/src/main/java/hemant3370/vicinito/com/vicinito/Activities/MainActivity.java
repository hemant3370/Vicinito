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
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemant3370.vicinito.com.vicinito.Adapters.CustomItemClickListener;
import hemant3370.vicinito.com.vicinito.Adapters.MatchGridAdapter;
import hemant3370.vicinito.com.vicinito.Applications.Initializer;
import hemant3370.vicinito.com.vicinito.Models.Stream.Stream;
import hemant3370.vicinito.com.vicinito.Models.Stream.StreamResponse;
import hemant3370.vicinito.com.vicinito.R;
import hemant3370.vicinito.com.vicinito.Retrofit.Client.RestClient;
import hemant3370.vicinito.com.vicinito.Retrofit.Services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener {
        @Bind(R.id.feed_recycler_view) RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private GridLayoutManager mLayoutManager;
        public CustomItemClickListener listener;
        @Bind(R.id.main_progress) View mProgressView;
        List<Stream> feed = new ArrayList<>();
        @OnClick(R.id.fab)
        public void fabAction(){

        }
        @Inject
        Retrofit mRetrofit;
        ApiInterface apiInterface;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((Initializer) getApplication()).getNetComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        attemptLogin();
        }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Activity activity = this;


        // use a linear layout manager
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
        Intent detail = new Intent(MainActivity.this,DetailActivity.class);
        detail.putExtra("id",feed.get(position).getId());
        startActivity(detail);
        }
        };

//        mAdapter = new MatchGridAdapter(this,feed,listener);
//        mRecyclerView.setAdapter(mAdapter);
        attemptLogin();
        }


        private void getFeedByTopic(String id) {
                if(id == null || id.equals("")){
                        attemptLogin();
                        return;
                }
                showProgress(true);
                if (mRetrofit == null){
                        mRetrofit = RestClient.getClient();
                }
                apiInterface = mRetrofit.create(ApiInterface.class);
                Call<List<Stream>> call = apiInterface.getFeedByTopic(id);
                call.enqueue(new Callback<List<Stream>>() {
                        @Override
                        public void onResponse(Call<List<Stream>> call, Response<List<Stream>> response) {

                                if (response.code() == 200 ){

                                        showProgress(false);
                                        feed = response.body();
                                        mAdapter = new MatchGridAdapter(MainActivity.this,feed,listener);
                                        mRecyclerView.setAdapter(mAdapter);
                                }
                                else {


                                        Toast.makeText(MainActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
                                }

                        }

                        @Override
                        public void onFailure(Call<List<Stream>> call, Throwable t) {

                                showProgress(false);
                                Toast.makeText(MainActivity.this,t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                });

        }
        private void attemptLogin() {

        showProgress(true);
        if (mRetrofit == null){
        mRetrofit = RestClient.getClient();
        }
        apiInterface = mRetrofit.create(ApiInterface.class);
        Call<StreamResponse> call = apiInterface.getFeed();
        call.enqueue(new Callback<StreamResponse>() {
@Override
public void onResponse(Call<StreamResponse> call, Response<StreamResponse> response) {

        if (response.code() == 200 ){

        showProgress(false);
        feed = response.body().getStream();
        mAdapter = new MatchGridAdapter(MainActivity.this,feed,listener);
        mRecyclerView.setAdapter(mAdapter);
        }
        else {


        Toast.makeText(MainActivity.this,response.errorBody().toString(),Toast.LENGTH_LONG).show();
        }

        }

@Override
public void onFailure(Call<StreamResponse> call, Throwable t) {

        showProgress(false);
        Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
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
@Override
public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();
        }
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
        return true;
        }

        return super.onOptionsItemSelected(item);
        }

@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        // Handle the camera action
        } else if (id == R.id.nav_gallery) {
                Intent o = new Intent(MainActivity.this,TopicsActivity.class);
                startActivityForResult(o, 1);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

                if (requestCode == 1) {
                        if(resultCode == Activity.RESULT_OK){
                                String id = data.getStringExtra("topicId");
                                getFeedByTopic(id);

                        }
                        if (resultCode == Activity.RESULT_CANCELED) {
                                //Write your code if there's no result
                                attemptLogin();
                        }
                }
        }
        }
