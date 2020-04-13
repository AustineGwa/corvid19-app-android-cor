package com.geeksarena.afyayangu.views.general;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.models.Country;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Country selectedCountry = (Country) getIntent().getSerializableExtra("country");
        getActionBar().setTitle(selectedCountry.getCountry());

    }
}
