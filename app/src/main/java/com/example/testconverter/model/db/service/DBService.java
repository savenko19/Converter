package com.example.testconverter.model.db.service;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DBService {

    private final Realm mRealm;

    public DBService(Context context) {
        Realm.init(context);
        RealmConfiguration mRealmConfiguration = new RealmConfiguration.Builder().name("rap.realm").build();
        Realm.setDefaultConfiguration(mRealmConfiguration);
        mRealm = Realm.getDefaultInstance();
    }

    public Realm getRealm() {
        return mRealm;
    }
}
