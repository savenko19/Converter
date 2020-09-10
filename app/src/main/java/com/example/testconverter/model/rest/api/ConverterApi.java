package com.example.testconverter.model.rest.api;

import com.example.testconverter.model.rest.data.DataRest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConverterApi {

    @GET("daily_json.js")
    Call<DataRest> getData();
}
