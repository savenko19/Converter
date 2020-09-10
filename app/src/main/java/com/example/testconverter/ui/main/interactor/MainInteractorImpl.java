package com.example.testconverter.ui.main.interactor;

import android.content.Context;

import com.example.testconverter.model.manager.Manager;
import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

public class MainInteractorImpl implements MainInteractor {

    private Manager mManager;

    public MainInteractorImpl(Manager manager) {
        mManager = manager;
    }

    @Override
    public void getCurrencyData(OnLoadListener<DataRest> onLoadListener) {
        mManager.getCurrencyData(onLoadListener);
    }

    @Override
    public void addCurrency(Currency currency) {
        mManager.addCurrency(currency);
    }
}
