package com.example.actives;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.example.actives.network.RestApi;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        RestApi.init(this);

        App.context = getApplicationContext();
    }

    public static Context getAppContext() {

        return App.context;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getAllNetworks().length != 0) {
            return true;
        }
        return false;
    }
}
