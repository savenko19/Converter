package com.example.testconverter;

import android.app.Application;
import android.content.Context;

import com.example.testconverter.model.manager.Manager;
import com.example.testconverter.model.manager.factory.ManagerFactory;

public class App extends Application {

    private Manager mManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mManager = ManagerFactory.createManager(this);
    }

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    public static Manager getManager(Context context) {
        return getApp(context).mManager;
    }
}
