package com.example.testconverter.model.rest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class DataRest {

    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Valute")
    @Expose
    private Map<String, CurrencyRest> currencyRestMap;

    public DataRest(String date, Map<String, CurrencyRest> currencyRestMap) {
        this.date = date;
        this.currencyRestMap = currencyRestMap;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, CurrencyRest> getCurrencyRestMap() {
        return currencyRestMap;
    }

    public void setCurrencyRestMap(Map<String, CurrencyRest> currencyRestMap) {
        this.currencyRestMap = currencyRestMap;
    }
}
