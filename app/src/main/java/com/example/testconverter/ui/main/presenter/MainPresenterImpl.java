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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    private MainInteractor mInteractor;

    public MainPresenterImpl(MainInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void viewIsReady() {
        //yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        if (PreferencesHelper.getUpdateDate() != null) {
            try {
                Date updateDate = simpleDateFormat.parse(PreferencesHelper.getUpdateDate());
                Calendar updateCal = new GregorianCalendar();
                Calendar currentCal = new GregorianCalendar();
                currentCal.setTime(new Date());
                updateCal.setTime(updateDate);

                if (currentCal.get(Calendar.DAY_OF_MONTH) == updateCal.get(Calendar.DAY_OF_MONTH) &&
                currentCal.get(Calendar.MONTH) == updateCal.get(Calendar.MONTH) &&
                currentCal.get(Calendar.YEAR) == updateCal.get(Calendar.YEAR)) {
                    getView().startConverter();
                } else {
                    loadCurrency();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            getView().startConverter();
        } else {
            loadCurrency();
        }
        getView().showProgressBar();

    }

    private void loadCurrency() {
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
                    getView().hideProgressBar();
                    getView().startConverter();
                }
            }

            @Override
            public void onLoadFailure(String errorMessage) {
                //Connection problem
                if (PreferencesHelper.getUpdateDate() != null) {
                    getView().startConverter();
                } else {
                    //Connection problem
                }
            }
        });

    }
}
