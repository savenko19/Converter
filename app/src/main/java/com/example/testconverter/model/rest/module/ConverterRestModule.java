package com.example.testconverter.model.rest.module;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.pojo.Data;
import com.example.testconverter.model.rest.api.ConverterApi;
import com.example.testconverter.model.rest.callback.RestCallback;
import com.example.testconverter.model.rest.data.CurrencyRest;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

import java.util.HashMap;
import java.util.Map;

public class ConverterRestModule implements RestModule {

    private final ConverterApi mApi;

    public ConverterRestModule(ConverterApi api) {
        mApi = api;
    }

    @Override
    public void getCurrencyData(final OnLoadListener<DataRest> onLoadListener) {
        mApi.getData().enqueue(new RestCallback<DataRest>(new OnLoadListener<DataRest>() {
            @Override
            public void onLoadSuccess(DataRest result) throws InterruptedException {
                Map<String, CurrencyRest> currencyMap = new HashMap<>();
                for (Map.Entry<String, CurrencyRest> entry : result.getCurrencyRestMap().entrySet()) {
                    CurrencyRest mCurrencyRest = entry.getValue();
                    currencyMap.put(entry.getKey(), mCurrencyRest);
                }

                onLoadListener.onLoadSuccess(new DataRest(result.getDate(), currencyMap));
            }

            @Override
            public void onLoadFailure(String errorMessage) {
                onLoadListener.onLoadFailure(errorMessage);
            }
        }));
    }
}
