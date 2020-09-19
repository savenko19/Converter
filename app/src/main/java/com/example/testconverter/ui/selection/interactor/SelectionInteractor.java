package com.example.testconverter.ui.selection.interactor;

import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.model.rest.data.DataRest;
import com.example.testconverter.model.rest.listener.OnLoadListener;

import java.util.List;

public interface SelectionInteractor {

    void getCurrencyData(OnLoadListener<DataRest> onLoadListener);

    List<Currency> getAllCurrencies();

    void addCurrency(Currency currency);
}
