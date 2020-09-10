package com.example.testconverter.model.rest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyRest {

    @SerializedName("ID")
    @Expose
    private String id;

    @SerializedName("NumCode")
    @Expose
    private String numCode;

    @SerializedName("CharCode")
    @Expose
    private String charCode;

    @SerializedName("Nominal")
    @Expose
    private int nominal;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Value")
    @Expose
    private double value;

    @SerializedName("Previous")
    @Expose
    private double previous;

    public CurrencyRest(String id, String numCode, String charCode, int nominal, String name, double value, double previous) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.previous = previous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }
}
