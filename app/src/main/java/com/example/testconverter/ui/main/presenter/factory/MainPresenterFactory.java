package com.example.testconverter.ui.main.presenter.factory;

import android.content.Context;

import com.example.testconverter.App;
import com.example.testconverter.ui.main.interactor.MainInteractor;
import com.example.testconverter.ui.main.interactor.MainInteractorImpl;
import com.example.testconverter.ui.main.presenter.MainPresenterImpl;

public class MainPresenterFactory {

    public static MainPresenterImpl createPresenter(Context context) {
        MainInteractor mainInteractor = new MainInteractorImpl(App.getManager(context));
        return new MainPresenterImpl(mainInteractor);
    }
}
