package com.example.testconverter.ui.main.view;

import com.example.testconverter.ui.mvp.MvpView;

public interface MainView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void startConverter();
}
