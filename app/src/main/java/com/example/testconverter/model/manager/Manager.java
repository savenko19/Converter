package com.example.testconverter.model.manager;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

import java.util.List;

public interface Manager {

    void getCurrencyData(OnLoadListener<DataRest> onLoadListener);

    void addCurrency(Currency currency);

    List<Currency> getAllCurrencies();

    Currency getSelectedCurrency();
}
