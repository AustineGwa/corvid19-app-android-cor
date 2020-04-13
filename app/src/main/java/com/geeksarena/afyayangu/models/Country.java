package com.geeksarena.afyayangu.models;

public class Country {

       private  String Country;
       private  String Slug;
       private  String ISO2;

    public Country() {
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getISO2() {
        return ISO2;
    }

    public void setISO2(String ISO2) {
        this.ISO2 = ISO2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Country='" + Country + '\'' +
                ", Slug='" + Slug + '\'' +
                ", ISO2='" + ISO2 + '\'' +
                '}';
    }
}
