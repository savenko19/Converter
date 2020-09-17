package com.example.testconverter.ui.converter.presenter.factory;

import android.content.Context;

import com.example.testconverter.App;
import com.example.testconverter.ui.converter.interactor.ConverterInteractor;
import com.example.testconverter.ui.converter.interactor.ConverterInteractorImpl;
import com.example.testconverter.ui.converter.presenter.ConverterPresenterImpl;

public class ConverterPresenterFactory {

    public static ConverterPresenterImpl createPresenter(Context context) {
        ConverterInteractor converterInteractor = new ConverterInteractorImpl(App.getManager(context));
        return new ConverterPresenterImpl(converterInteractor);
    }
}
