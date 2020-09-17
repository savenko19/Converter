package com.example.testconverter.model.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CurrencyEntity extends RealmObject {

    @PrimaryKey
    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private float value;
    private float previous;
    private boolean isSelect;

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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPrevious() {
        return previous;
    }

    public void setPrevious(float previous) {
        this.previous = previous;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
