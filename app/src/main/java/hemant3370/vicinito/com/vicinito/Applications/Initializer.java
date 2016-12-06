package hemant3370.vicinito.com.vicinito.Applications;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import hemant3370.vicinito.com.vicinito.Dagger.Component.DaggerNetComponent;
import hemant3370.vicinito.com.vicinito.Dagger.Component.NetComponent;
import hemant3370.vicinito.com.vicinito.Dagger.Module.AppModule;
import hemant3370.vicinito.com.vicinito.Dagger.Module.NetModule;


/**
 * Created by rahulkumarlohra on 18/04/16.
 */
public class Initializer extends Application {

    private static Initializer sInstance;

    public DisplayMetrics metrics;
  ;
    public static Initializer getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static void saveToPreferences(Context context, String preferenceName, boolean preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

    public static boolean readFromPreferences(Context context, String preferenceName, boolean defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getBoolean(preferenceName, defaultValue);
    }
    public DisplayMetrics getMetrics() {
        metrics = new DisplayMetrics();

        metrics = getResources().getDisplayMetrics();
        return metrics;
    }
    private NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(getApplicationContext()))
                .build();
                sInstance = this;

    }



    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
