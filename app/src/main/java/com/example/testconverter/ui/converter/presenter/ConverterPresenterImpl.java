package com.example.testconverter.ui.converter.presenter;

import com.example.testconverter.ui.converter.interactor.ConverterInteractor;
import com.example.testconverter.ui.converter.view.ConverterView;
import com.example.testconverter.ui.mvp.BasePresenter;

public class ConverterPresenterImpl extends BasePresenter<ConverterView> implements ConverterPresenter {

    private ConverterInteractor mInteractor;

    public ConverterPresenterImpl(ConverterInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void viewIsReady() {
        getView().showSelectedCurrencyInfo(mInteractor.getSelectedCurrency());
        getView().initETs(mInteractor.getSelectedCurrency());
    }
}
