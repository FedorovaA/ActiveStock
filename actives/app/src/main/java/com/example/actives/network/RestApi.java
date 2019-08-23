package com.example.actives.network;

import android.content.Context;

import com.example.actives.util.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angelina Fedorova
 */

public class RestApi {
    private static Retrofit retrofit = null;

    public static void init(Context context) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(interceptor);

        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.SERVER_URL)
                .client(okHttpClient.build())
                .build();
    }

    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null){
            throw new IllegalStateException("Call `RestApi.init(Context)` before calling this method.");
        }
        return retrofit.create(serviceClass);
    }
}
