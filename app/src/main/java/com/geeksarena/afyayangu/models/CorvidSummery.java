package com.geeksarena.afyayangu.models;

import java.util.List;

public class CorvidSummery {

    private  Global Global;
    private List<SumaryPerCountry> countries;
    private String Date;

    public com.geeksarena.afyayangu.models.Global getGlobal() {
        return Global;
    }

    public void setGlobal(com.geeksarena.afyayangu.models.Global global) {
        Global = global;
    }

    public List<SumaryPerCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<SumaryPerCountry> countries) {
        this.countries = countries;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "CorvidSummery{" +
                "Global=" + Global +
                ", countries=" + countries +
                ", Date='" + Date + '\'' +
                '}';
    }
}
