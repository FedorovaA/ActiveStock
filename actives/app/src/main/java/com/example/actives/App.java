package com.example.actives;

import android.app.Application;

import com.example.actives.api.RestApi;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestApi.init(this);
    }
}
