package com.example.testconverter.ui.main.presenter;

import android.util.Log;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.preferences.PreferencesHelper;
import com.example.testconverter.model.rest.data.CurrencyRest;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;
import com.example.testconverter.ui.main.interactor.MainInteractor;
import com.example.testconverter.ui.main.view.MainView;
import com.example.testconverter.ui.mvp.BasePresenter;

import java.util.Map;

public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    private MainInteractor mInteractor;

    public MainPresenterImpl(MainInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void viewIsReady() {
        getView().showProgressBar();
        mInteractor.getCurrencyData(new OnLoadListener<DataRest>() {
            @Override
            public void onLoadSuccess(DataRest result) throws InterruptedException {
                //Success
                for (Map.Entry<String, CurrencyRest> entry : result.getCurrencyRestMap().entrySet()) {
                    Log.d("myLog", "Date: " + result.getDate());
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
                    getView().hideProgressBar();
                    getView().startConverter();
                }
            }

            @Override
            public void onLoadFailure(String errorMessage) {
                //Connection problem
            }
        });
    }
}
