package hemant3370.vicinito.com.vicinito.Retrofit.Client;


import hemant3370.vicinito.com.vicinito.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahulkumarlohra on 17/06/16.
 */
public class RestClient {
    public static final String BASE_URL = Constants.MyUrl.BASE_URL;
    private static Retrofit retrofit = null;

// set your desired log level


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
