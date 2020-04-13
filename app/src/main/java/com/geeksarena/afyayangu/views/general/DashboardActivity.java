package com.geeksarena.afyayangu.views.general;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.api.RetrofitServiceInstance;
import com.geeksarena.afyayangu.models.CorvidSummery;
import com.geeksarena.afyayangu.models.CountryCorvidData;
import com.geeksarena.afyayangu.models.SumaryPerCountry;
import com.geeksarena.afyayangu.views.users.UserProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
   private  ProgressDialog progressDialog;
   private  CorvidSummery corvidSummery;
   private  List<SumaryPerCountry> sumaryPerCountryList;
   private  String currentDataDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        progressDialog = new ProgressDialog(this);



        RetrofitServiceInstance.getApiService().getFullSummary().enqueue(new Callback<CorvidSummery>() {
            @Override
            public void onResponse(Call<CorvidSummery> call, Response<CorvidSummery> response) {
                corvidSummery = response.body();

                System.out.println("Response "+corvidSummery);
                updateUI(corvidSummery);

            }

            @Override
            public void onFailure(Call<CorvidSummery> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "could not Get Data" +t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Response "+t.getMessage() + " Error "+t.getStackTrace());
            }
        });
    }

    private void updateUI(CorvidSummery corvidSummery) {
        sumaryPerCountryList = corvidSummery.getCountries();
        currentDataDate = corvidSummery.getDate();
        Toast.makeText(getApplicationContext(),"Date "+currentDataDate, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.user_home_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.profile){
            startActivity(new Intent(DashboardActivity.this, UserProfile.class));
        }
        return super.onOptionsItemSelected(item);
    }
}









//        RetrofitServiceInstance.getApiService().getCountries().enqueue(new Callback<List<Country>>() {
//            @Override
//            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
//                progressDialog.show();
//                List<Country> countries = response.body();
//
//                for(Country country : countries){
//                    System.out.println("======= \n"+country.toString() +"\n ======= ");
//                }
//                //getListFeaturedBussinesses(bussinessList);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Country>> call, Throwable t) {
//               progressDialog.dismiss();
//                Toast.makeText(UserHomeActivity.this, "Error failed to fetch data", Toast.LENGTH_SHORT).show();
//                System.out.println("response  Error  "+ t.getMessage());
//            }
//        });

//        RetrofitServiceInstance.getApiService().getConfirmedCasesInKenya().enqueue(new Callback<List<CountryCorvidData>>() {
//            @Override
//            public void onResponse(Call<List<CountryCorvidData>> call, Response<List<CountryCorvidData>> response) {
//                progressDialog.show();
//                List<CountryCorvidData> countries = response.body();
//
//                for(CountryCorvidData country : countries){
//                    System.out.println("======= \n"+country.toString() +"\n ======= ");
//                }
//                //getListFeaturedBussinesses(bussinessList);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<CountryCorvidData>> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(DashboardActivity.this, "Error failed to fetch data", Toast.LENGTH_SHORT).show();
//                System.out.println("response  Error  "+ t.getMessage());
//            }
//        });
