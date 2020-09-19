package com.example.testconverter.ui.converter.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testconverter.R;
import com.example.testconverter.model.pojo.Currency;
import com.example.testconverter.ui.converter.presenter.ConverterPresenter;
import com.example.testconverter.ui.converter.presenter.factory.ConverterPresenterFactory;
import com.example.testconverter.ui.selection.view.SelectionActivity;

import java.text.DecimalFormat;

public class ConverterActivity extends AppCompatActivity implements ConverterView{

    private ConverterPresenter mPresenter;

    //Currency info
    private TextView currencyName;
    private TextView currencyNameCode;
    private EditText rurEt;
    private EditText currencyEt;
    private TextView currentValue;
    private ImageView statusValue;
    private TextView preValue;

    private TextView rurInfo;

    private Button selectCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mPresenter = ConverterPresenterFactory.createPresenter(this);
        mPresenter.onAttachView(this);

        currencyName = findViewById(R.id.currency_title);
        currencyNameCode = findViewById(R.id.currency_code_name_title);

        rurEt = findViewById(R.id.rur_et);
        currencyEt = findViewById(R.id.currency_et);

        currentValue = findViewById(R.id.value);
        statusValue = findViewById(R.id.status_ic);
        preValue = findViewById(R.id.pre_value);

        rurInfo = findViewById(R.id.rur_info);

        selectCurrency = findViewById(R.id.currency_list_btn);
        selectCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConverterActivity.this, SelectionActivity.class);
                startActivity(intent);
                finish();
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
    public void showSelectedCurrencyInfo(Currency selectedCurrency) {
        currencyName.setText(selectedCurrency.getName());
        currencyNameCode.setText(selectedCurrency.getCharCode());

        currentValue.setText(String.valueOf(selectedCurrency.getValue() / selectedCurrency.getNominal()) + " RUR");
        preValue.setText(String.valueOf(selectedCurrency.getPrevious() / selectedCurrency.getNominal()) + " RUR");

        if (selectedCurrency.getValue() / selectedCurrency.getNominal()
                > selectedCurrency.getPrevious() / selectedCurrency.getNominal()) {
            statusValue.setImageResource(R.drawable.up_status_ic);
        } else {
            statusValue.setImageResource(R.drawable.down_status_ic);
        }

        rurInfo.setText("1 " + selectedCurrency.getCharCode() + " =");
    }

    @Override
    public void initETs(Currency selectedCurrency) {



        float currencyValue = selectedCurrency.getValue();
        float currencyNominal = selectedCurrency.getNominal();

        TextWatcher rurTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //convert

                if (s.toString().equals("")) {
                    currencyEt.setText("");
                } else {
                    double rurValue = Double.valueOf(s.toString());
                    currencyEt.setText(String.format("%.4f", ((rurValue / currencyValue) * currencyNominal)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        rurEt.addTextChangedListener(rurTextWatcher);
    }
}