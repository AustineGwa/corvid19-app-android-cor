package com.geeksarena.afyayangu.models;

public class Global {

    private String  NewConfirmed;
    private String  TotalConfirmed;
    private String  NewDeaths;
    private String  TotalDeaths;
    private String  NewRecovered;
    private String  TotalRecovered;

    public Global() {
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

    @Override
    public String toString() {
        return "Global{" +
                "NewConfirmed='" + NewConfirmed + '\'' +
                ", TotalConfirmed='" + TotalConfirmed + '\'' +
                ", NewDeaths='" + NewDeaths + '\'' +
                ", TotalDeaths='" + TotalDeaths + '\'' +
                ", NewRecovered='" + NewRecovered + '\'' +
                ", TotalRecovered='" + TotalRecovered + '\'' +
                '}';
    }
}
