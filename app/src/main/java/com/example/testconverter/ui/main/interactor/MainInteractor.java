package com.example.testconverter.ui.main.interactor;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

public interface MainInteractor {

    void getCurrencyData(OnLoadListener<DataRest> onLoadListener);

    void addCurrency(Currency currency);
}
