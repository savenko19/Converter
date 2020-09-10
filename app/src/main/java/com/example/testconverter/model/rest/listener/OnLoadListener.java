package com.example.testconverter.model.rest.listener;

public interface OnLoadListener<T> {

    void onLoadSuccess(T result) throws InterruptedException;
    void onLoadFailure(String errorMessage);
}
