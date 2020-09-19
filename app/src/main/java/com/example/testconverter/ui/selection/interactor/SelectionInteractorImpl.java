package com.example.testconverter.ui.selection.interactor;

import com.example.testconverter.model.manager.Manager;
import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

import java.util.List;

public class SelectionInteractorImpl implements SelectionInteractor {

    private Manager mManager;

    public SelectionInteractorImpl(Manager manager) {
        mManager = manager;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return mManager.getAllCurrencies();
    }

    @Override
    public void addCurrency(Currency currency) {
        mManager.addCurrency(currency);
    }

    @Override
    public void getCurrencyData(OnLoadListener<DataRest> onLoadListener) {
        mManager.getCurrencyData(onLoadListener);
    }
}
