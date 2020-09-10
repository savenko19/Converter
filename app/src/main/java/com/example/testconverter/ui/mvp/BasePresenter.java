package com.example.testconverter.ui.mvp;

public abstract class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    T view = null;

    @Override
    public void onAttachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    public T getView() {
        return view;
    }

}
