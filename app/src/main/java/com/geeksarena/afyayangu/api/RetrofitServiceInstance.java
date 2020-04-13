package com.geeksarena.afyayangu.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceInstance {

    private static Retrofit retrofit;

    private static String baseUrl = "https://api.covid19api.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static  ApiServices getApiService(){
        return  getRetrofitInstance().create(ApiServices.class);
    }

}
