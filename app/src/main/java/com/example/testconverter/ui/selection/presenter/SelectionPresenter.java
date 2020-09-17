package com.example.testconverter.ui.selection.presenter;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.mvp.MvpPresenter;
import com.example.testconverter.ui.selection.view.SelectionView;

public interface SelectionPresenter extends MvpPresenter<SelectionView> {

    void addCurrency(Currency currency);
}
