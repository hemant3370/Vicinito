package hemant3370.vicinito.com.vicinito.Dagger.Module;

import android.content.Context;



import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hemant3370.vicinito.com.vicinito.Constants;
import hemant3370.vicinito.com.vicinito.Retrofit.Interceptors.CachingControlInterceptor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Rahul on 6/20/2016.
 */
@Module
public class NetModule {
    String string;
    String BASE_URL = Constants.MyUrl.BASE_URL;
    String TAG = "NetModule";
    private Context context;
    public NetModule(Context context) {
        this.context = context;
    }



    @Provides
    @Singleton
    Retrofit provideRetrofit()
    {
        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(context.getCacheDir(), "http"), SIZE_OF_CACHE);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
                                      @Override
                                      public Response intercept(Chain chain) throws IOException {
                                          Request original = chain.request();

                                          Request request = original.newBuilder()
                                                  .header("Content-Type", "application/json")
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  })
        .addNetworkInterceptor(new CachingControlInterceptor())
                .cache(cache);
                OkHttpClient client = httpClient.build();


        Retrofit retrofit = null;
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        return retrofit;

    }




}
