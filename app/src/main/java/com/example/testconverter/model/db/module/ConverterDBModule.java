package com.example.testconverter.model.db.module;

import com.example.testconverter.model.db.entity.CurrencyEntity;
import com.example.testconverter.model.db.service.DBService;
import com.example.testconverter.model.pojo.Currency;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ConverterDBModule implements DBModule {

    private DBService mDBService;
    private Realm mRealm;

    public ConverterDBModule(DBService dbService) {
        mDBService = dbService;
        mRealm = dbService.getRealm();
    }

    @Override
    public void addCurrency(Currency currency) {
        CurrencyEntity mCurrencyEntity = mRealm.where(CurrencyEntity.class).equalTo("id", currency.getId()).findFirst();

        mRealm.beginTransaction();
        if (mCurrencyEntity == null) {
            mCurrencyEntity = mRealm.createObject(CurrencyEntity.class, currency.getId());
            mCurrencyEntity.setNumCode(currency.getNumCode());
            mCurrencyEntity.setCharCode(currency.getCharCode());
            mCurrencyEntity.setNominal(currency.getNominal());
            mCurrencyEntity.setName(currency.getName());
            mCurrencyEntity.setValue(currency.getValue());
            mCurrencyEntity.setPrevious(currency.getPrevious());
        } else {

        }

        mRealm.commitTransaction();
    }

    @Override
    public List<Currency> getAllCurrencies() {
        RealmResults<CurrencyEntity> mCurrencyEntities = mRealm.where(CurrencyEntity.class).findAll();

        if (mCurrencyEntities != null) {
            ArrayList<Currency> mCurrencies = new ArrayList<>();
            for (CurrencyEntity currencyEntity : mCurrencyEntities) {
                mCurrencies.add(new Currency(
                   currencyEntity.getId(),
                   currencyEntity.getNumCode(),
                   currencyEntity.getCharCode(),
                   currencyEntity.getNominal(),
                   currencyEntity.getName(),
                   currencyEntity.getValue(),
                   currencyEntity.getPrevious()
                ));
            }

            return mCurrencies;
        } else {
            return null;
        }
    }
}
