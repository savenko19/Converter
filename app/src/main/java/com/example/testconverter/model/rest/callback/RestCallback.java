package com.example.testconverter.model.rest.callback;

import com.example.testconverter.model.rest.listener.OnLoadListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestCallback<T> implements Callback<T> {

    private OnLoadListener<T> mListener;

    public RestCallback(OnLoadListener<T> listener) {
        mListener = listener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T body = response.body();

        if (response.isSuccessful()) {
            try {
                mListener.onLoadSuccess(body);
            } catch (Exception e) {

            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mListener.onLoadFailure(t.getMessage());
    }
}
