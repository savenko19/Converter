package com.example.testconverter.ui.mvp;

public interface MvpPresenter<V extends MvpView> {

    void onAttachView(V mvpView);

    void viewIsReady();

    void onDetachView();

}
