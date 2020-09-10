package com.example.testconverter.model.rest.module;

import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

public interface RestModule {

    void getCurrencyData(OnLoadListener<DataRest> onLoadListener);
}
