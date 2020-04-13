package com.geeksarena.afyayangu.api;


import com.geeksarena.afyayangu.models.CorvidSummery;
import com.geeksarena.afyayangu.models.Country;
import com.geeksarena.afyayangu.models.CountryCorvidData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("/countries")
    Call<List<Country>> getCountries();

    @GET("/country/kenya/status/confirmed")
    Call<List<CountryCorvidData>> getConfirmedCasesInKenya();

    @GET("/summary")
    Call<CorvidSummery> getFullSummary();

}
