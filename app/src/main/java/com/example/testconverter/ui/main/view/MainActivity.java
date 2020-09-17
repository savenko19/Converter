package com.example.testconverter.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.testconverter.R;
import com.example.testconverter.model.preferences.PreferencesHelper;
import com.example.testconverter.ui.main.presenter.MainPresenter;
import com.example.testconverter.ui.main.presenter.factory.MainPresenterFactory;
import com.example.testconverter.ui.selection.view.SelectionActivity;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mPresenter;

    private ProgressBar loadStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferencesHelper.initPreferences(this);

        mPresenter = MainPresenterFactory.createPresenter(this);
        mPresenter.onAttachView(this);

        loadStatus = findViewById(R.id.load_status);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.viewIsReady();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showProgressBar() {
        loadStatus.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        loadStatus.setVisibility(View.GONE);
    }

    @Override
    public void startConverter() {
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
        finish();
    }
}