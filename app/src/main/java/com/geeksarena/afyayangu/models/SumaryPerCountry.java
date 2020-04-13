package com.geeksarena.afyayangu.models;

public class SumaryPerCountry {
    private String  Country;
    private String  CountryCode;
    private String  Slug;
    private String  NewConfirmed;
    private String  TotalConfirmed;
    private String  NewDeaths;
    private String  TotalDeaths;
    private String  NewRecovered;
    private String  TotalRecovered;
    private String  Date;

    public SumaryPerCountry() {
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        NewRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "SumemeryPerCountry{" +
                "Country='" + Country + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", Slug='" + Slug + '\'' +
                ", NewConfirmed='" + NewConfirmed + '\'' +
                ", TotalConfirmed='" + TotalConfirmed + '\'' +
                ", NewDeaths='" + NewDeaths + '\'' +
                ", TotalDeaths='" + TotalDeaths + '\'' +
                ", NewRecovered='" + NewRecovered + '\'' +
                ", TotalRecovered='" + TotalRecovered + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
