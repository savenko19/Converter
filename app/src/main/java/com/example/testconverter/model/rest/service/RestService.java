package com.example.testconverter.model.rest.service;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private final Retrofit mRetrofit;

    private static final String SERVER_URL = "https://www.cbr-xml-daily.ru/";

    public RestService() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .client(createClient())
                .build();
    }


    private OkHttpClient createClient() {
        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mBuilder.addInterceptor(mHttpLoggingInterceptor);

        return mBuilder.build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
