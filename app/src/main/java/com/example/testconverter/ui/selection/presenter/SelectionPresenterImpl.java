package com.example.testconverter.ui.selection.presenter;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.mvp.BasePresenter;
import com.example.testconverter.ui.selection.interactor.SelectionInteractor;
import com.example.testconverter.ui.selection.view.SelectionView;

import java.util.ArrayList;

public class SelectionPresenterImpl extends BasePresenter<SelectionView> implements SelectionPresenter {

    private SelectionInteractor mInteractor;

    public SelectionPresenterImpl(SelectionInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void viewIsReady() {
        getView().showCurrencies((ArrayList<Currency>) mInteractor.getAllCurrencies());
    }
}
