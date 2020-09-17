package com.example.testconverter.ui.converter.interactor;

import com.example.testconverter.model.manager.Manager;
import com.example.testconverter.model.pojo.Currency;

public class ConverterInteractorImpl implements ConverterInteractor {

    private Manager mManager;

    public ConverterInteractorImpl(Manager manager) {
        mManager = manager;
    }

    @Override
    public Currency getSelectedCurrency() {
        return mManager.getSelectedCurrency();
    }
}
