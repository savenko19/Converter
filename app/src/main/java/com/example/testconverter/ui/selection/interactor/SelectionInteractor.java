package com.example.testconverter.ui.selection.interactor;

import com.example.testconverter.model.pojo.Currency;

import java.util.List;

public interface SelectionInteractor {

    List<Currency> getAllCurrencies();

    void addCurrency(Currency currency);
}
