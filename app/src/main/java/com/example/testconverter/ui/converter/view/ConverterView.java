package com.example.testconverter.ui.converter.view;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.mvp.MvpView;

public interface ConverterView extends MvpView {

    void showSelectedCurrencyInfo(Currency selectedCurrency);

    void initETs(Currency selectedCurrency);
}
