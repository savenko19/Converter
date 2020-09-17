package com.example.testconverter.model.manager;

import com.example.testconverter.model.db.module.DBModule;
import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;
import com.example.testconverter.model.rest.module.RestModule;

import java.util.List;

public class ConverterManager implements Manager {

    private final RestModule mRestModule;
    private final DBModule mDBModule;

    public ConverterManager(RestModule restModule, DBModule dbModule) {
        mRestModule = restModule;
        mDBModule = dbModule;
    }

    @Override
    public void getCurrencyData(OnLoadListener<DataRest> onLoadListener) {
        mRestModule.getCurrencyData(onLoadListener);
    }

    @Override
    public void addCurrency(Currency currency) {
        mDBModule.addCurrency(currency);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return mDBModule.getAllCurrencies();
    }

    @Override
    public Currency getSelectedCurrency() {
        return mDBModule.getSelectedCurrency();
    }
}
