package com.example.testconverter.model.pojo;

import java.util.Map;

public class Data {

    private String date;
    private Map<String, Currency> currencyMap;

    public Data(String date, Map<String, Currency> currencyMap) {
        this.date = date;
        this.currencyMap = currencyMap;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Currency> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(Map<String, Currency> currencyMap) {
        this.currencyMap = currencyMap;
    }
}
