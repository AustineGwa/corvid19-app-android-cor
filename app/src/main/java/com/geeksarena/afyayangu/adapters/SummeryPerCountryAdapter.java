package com.geeksarena.afyayangu.adapters;

import com.geeksarena.afyayangu.models.CorvidSummery;
import com.geeksarena.afyayangu.models.Global;

import java.util.List;

public class SummeryPerCountryAdapter {
    private Global global;
    private List<CorvidSummery> Countries;
    private String  Date;

    public SummeryPerCountryAdapter() {
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<CorvidSummery> getCountries() {
        return Countries;
    }

    public void setCountries(List<CorvidSummery> countries) {
        Countries = countries;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "SummeryPerCountryAdapter{" +
                "global=" + global +
                ", Countries=" + Countries +
                ", Date='" + Date + '\'' +
                '}';
    }
}
