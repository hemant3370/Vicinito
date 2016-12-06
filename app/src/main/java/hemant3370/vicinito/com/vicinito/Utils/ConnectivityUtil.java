package hemant3370.vicinito.com.vicinito.Utils;

/**
 * Created by HemantSingh on 21/11/16.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.net.ConnectivityManager.TYPE_WIFI;

public class ConnectivityUtil {

    private final ConnectivityManager connectivityManager;

    public ConnectivityUtil(Context ctx) {
        connectivityManager = (ConnectivityManager) ctx
                .getSystemService(CONNECTIVITY_SERVICE);
    }



    public boolean connected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public boolean onWiFi() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return connected() && networkInfo.getType() == TYPE_WIFI;
    }

}
