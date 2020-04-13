package com.geeksarena.afyayangu.models;

public class CountryCorvidData {
    private  String Country;
    private  String   CountryCode;
    private  String   Lat;
    private  String   Lon;
    private  String  Cases;
    private  String Status;
    private  String Date;

    public CountryCorvidData() {
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

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLon() {
        return Lon;
    }

    public void setLon(String lon) {
        Lon = lon;
    }

    public String getCases() {
        return Cases;
    }

    public void setCases(String cases) {
        Cases = cases;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "CountryData{" +
                "Country='" + Country + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", Lat='" + Lat + '\'' +
                ", Lon='" + Lon + '\'' +
                ", Cases='" + Cases + '\'' +
                ", Status='" + Status + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
