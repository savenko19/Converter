package com.example.testconverter.model.db.module;

import com.example.testconverter.model.pojo.Currency;

import java.util.List;

public interface DBModule {

    void addCurrency(Currency currency);

    List<Currency> getAllCurrencies();

    Currency getSelectedCurrency();
}
