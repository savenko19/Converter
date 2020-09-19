package com.example.testconverter.ui.selection.presenter;

import android.util.Log;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.preferences.PreferencesHelper;
import com.example.testconverter.model.rest.data.CurrencyRest;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;
import com.example.testconverter.ui.mvp.BasePresenter;
import com.example.testconverter.ui.selection.interactor.SelectionInteractor;
import com.example.testconverter.ui.selection.view.SelectionView;

import java.util.ArrayList;
import java.util.Map;

public class SelectionPresenterImpl extends BasePresenter<SelectionView> implements SelectionPresenter {

    private SelectionInteractor mInteractor;

    public SelectionPresenterImpl(SelectionInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void viewIsReady() {
        getView().showDialog();
        getView().showCurrencies((ArrayList<Currency>) mInteractor.getAllCurrencies());
    }

    @Override
    public void addCurrency(Currency currency) {
        mInteractor.addCurrency(currency);
    }

    @Override
    public ArrayList<Currency> updateData() {
        loadCurrency();
        return (ArrayList<Currency>) mInteractor.getAllCurrencies();
    }

    private void loadCurrency() {
        Log.d("myLog", "Update");
        mInteractor.getCurrencyData(new OnLoadListener<DataRest>() {
            @Override
            public void onLoadSuccess(DataRest result) throws InterruptedException {
                //Success
                PreferencesHelper.setUpdateDate(result.getDate());
                for (Map.Entry<String, CurrencyRest> entry : result.getCurrencyRestMap().entrySet()) {
                    CurrencyRest currencyRest = entry.getValue();
                    Currency currency = new Currency(
                            currencyRest.getId(),
                            currencyRest.getNumCode(),
                            currencyRest.getCharCode(),
                            currencyRest.getNominal(),
                            currencyRest.getName(),
                            currencyRest.getValue(),
                            currencyRest.getPrevious()
                    );

                    mInteractor.addCurrency(currency);

                }
            }

            @Override
            public void onLoadFailure(String errorMessage) {

            }
        });

    }
}
