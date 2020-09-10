package com.example.testconverter.ui.selection.view;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.mvp.MvpView;

import java.util.ArrayList;

public interface SelectionView extends MvpView {

    void showCurrencies(ArrayList<Currency> currencies);
}
