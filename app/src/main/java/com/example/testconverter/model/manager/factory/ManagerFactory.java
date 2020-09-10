package com.example.testconverter.model.manager.factory;

import android.content.Context;

import com.example.testconverter.model.db.module.ConverterDBModule;
import com.example.testconverter.model.db.module.DBModule;
import com.example.testconverter.model.db.service.DBService;
import com.example.testconverter.model.manager.ConverterManager;
import com.example.testconverter.model.rest.api.ConverterApi;
import com.example.testconverter.model.rest.module.ConverterRestModule;
import com.example.testconverter.model.rest.module.RestModule;
import com.example.testconverter.model.rest.service.RestService;

public class ManagerFactory {

    public static ConverterManager createManager(Context context) {
        RestService mRestService = new RestService();
        RestModule mRestModule = new ConverterRestModule(mRestService.getRetrofit().create(ConverterApi.class));

        DBService mDBService = new DBService(context);
        DBModule mDBModule = new ConverterDBModule(mDBService);

        return new ConverterManager(mRestModule, mDBModule);
    }
}
