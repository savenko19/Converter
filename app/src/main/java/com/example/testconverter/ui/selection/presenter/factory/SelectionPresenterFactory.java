package com.example.testconverter.ui.selection.presenter.factory;

import android.content.Context;

import com.example.testconverter.App;
import com.example.testconverter.ui.selection.interactor.SelectionInteractor;
import com.example.testconverter.ui.selection.interactor.SelectionInteractorImpl;
import com.example.testconverter.ui.selection.presenter.SelectionPresenterImpl;

public class SelectionPresenterFactory {

    public static SelectionPresenterImpl createPresenter(Context context) {
        SelectionInteractor selectionInteractor = new SelectionInteractorImpl(App.getManager(context));
        return new SelectionPresenterImpl(selectionInteractor);
    }
}
