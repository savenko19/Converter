package com.example.testconverter.ui.selection.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testconverter.R;
import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.converter.view.ConverterActivity;
import com.example.testconverter.ui.selection.adapter.CurrencyAdapter;
import com.example.testconverter.ui.selection.presenter.SelectionPresenter;
import com.example.testconverter.ui.selection.presenter.factory.SelectionPresenterFactory;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity implements SelectionView,
        CurrencyAdapter.OnItemClickListener {

    private SelectionPresenter mPresenter;

    private RecyclerView currencyRecycler;
    private CurrencyAdapter mCurrencyAdapter;

    private AlertDialog.Builder aBuilder;
    private AlertDialog dialog;

    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        mPresenter = SelectionPresenterFactory.createPresenter(this);
        mPresenter.onAttachView(this);

        currencyRecycler = findViewById(R.id.currency_recycler);
        currencyRecycler.setLayoutManager(new LinearLayoutManager(this));

        updateButton = findViewById(R.id.update_btn);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update
                mPresenter.updateData();
            }
        });
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
    public void showCurrencies(ArrayList<Currency> currencies) {
        mCurrencyAdapter = new CurrencyAdapter(currencies, this);
        currencyRecycler.setAdapter(mCurrencyAdapter);
    }

    @Override
    public void showDialog() {
        aBuilder = new AlertDialog.Builder(this);
        View customView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        aBuilder.setView(customView);
        dialog = aBuilder.create();
        dialog.show();
    }

    @Override
    public void onItemClick(ArrayList<Currency> currencies) {

        for (Currency currency : currencies) {
            mPresenter.addCurrency(currency);
        }
        Intent intent = new Intent(SelectionActivity.this, ConverterActivity.class);
        startActivity(intent);
    }


}