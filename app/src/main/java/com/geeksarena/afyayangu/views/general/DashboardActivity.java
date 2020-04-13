package com.geeksarena.afyayangu.views.general;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.adapters.AffectedCountriesAdapter;
import com.geeksarena.afyayangu.api.RetrofitServiceInstance;
import com.geeksarena.afyayangu.interfaces.CountryClickListener;
import com.geeksarena.afyayangu.models.CorvidSummery;
import com.geeksarena.afyayangu.models.Country;
import com.geeksarena.afyayangu.models.CountryCorvidData;
import com.geeksarena.afyayangu.models.SumaryPerCountry;
import com.geeksarena.afyayangu.views.users.UserProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
   private  ProgressDialog progressDialog;
   private  CorvidSummery corvidSummery;
   private  List<SumaryPerCountry> sumaryPerCountryList;
   private  String currentDataDate;
   private TextView accountUserNameTextView;
   private  View headerView;

   private Toolbar toolbar;
   private DrawerBuilder drawerBuilder;
   private AccountHeaderBuilder headerBuilder;
   private ProfileDrawerItem profileDrawerItem;
   private CircleImageView accountCircleImageView;

   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        recyclerView = findViewById(R.id.countries_summary);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));



        toolbar = findViewById(R.id.dashboard_toolbar);
        progressDialog = new ProgressDialog(this);
        LayoutInflater inflater = (LayoutInflater) DashboardActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        headerView = inflater.inflate(R.layout.client_header_layout, null);
        accountCircleImageView = headerView.findViewById(R.id.client_header_account_image_view);
        accountUserNameTextView = headerView.findViewById(R.id.client_header_user_name_text_view);
        setupNavDrawer();
        displayCountries();



    }

    private void displayCountries() {


        RetrofitServiceInstance.getApiService().getCountries().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                progressDialog.show();
                List<Country> countries = response.body();
               updateCountriesList(countries);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
               progressDialog.dismiss();
                Toast.makeText(DashboardActivity.this, "Error failed to fetch data", Toast.LENGTH_SHORT).show();
                System.out.println("response  Error  "+ t.getMessage());
            }
        });
    }

    private void updateCountriesList(List<Country> countries) {

        AffectedCountriesAdapter affectedCountriesAdapter = new AffectedCountriesAdapter(countries, new CountryClickListener() {
            @Override
            public void onCountryClick(Country country) {
                Intent intent = new Intent(DashboardActivity.this, CountryDetailActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(affectedCountriesAdapter);

    }

    private void updateUI(CorvidSummery corvidSummery) {
        sumaryPerCountryList = corvidSummery.getCountries();
        currentDataDate = corvidSummery.getDate();
        Toast.makeText(getApplicationContext(),"Date "+currentDataDate, Toast.LENGTH_SHORT).show();
    }

    private void setupNavDrawer() {

        String userName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        accountUserNameTextView.setText(userName);

        headerBuilder = new AccountHeaderBuilder();
        profileDrawerItem = new ProfileDrawerItem();

        drawerBuilder = new DrawerBuilder();
        Drawer result = drawerBuilder
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(headerView)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(0).withName("Dashboard"),
                        new PrimaryDrawerItem().withIdentifier(1).withName("Keeping Safe"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("About Corvid-19"),
                        new PrimaryDrawerItem().withIdentifier(3).withName("Map"),
                        new PrimaryDrawerItem().withIdentifier(4).withName("Contact Tracing"),
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(@org.jetbrains.annotations.Nullable View view, int i, @NotNull IDrawerItem<?> iDrawerItem) {
                        // do something with the clicked item

                        int identifire = (int) iDrawerItem.getIdentifier();
                        switch (identifire) {
                            case 0:
                                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(), KeepingSafeActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(getApplicationContext(), AboutCorvid19Activity.class));
                                break;
                            case 3:
                                startActivity(new Intent(getApplicationContext(), MyMapViewActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(getApplicationContext(), ContactTracingActivity.class));


                            default:
                                Toast.makeText(getApplicationContext(), "slider item clicked", Toast.LENGTH_SHORT).show();


                        }
                        return false;
                    }
                }).build();

        accountCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, UserProfile.class));
            }
        });

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

//
//
//        RetrofitServiceInstance.getApiService().getFullSummary().enqueue(new Callback<CorvidSummery>() {
//@Override
//public void onResponse(Call<CorvidSummery> call, Response<CorvidSummery> response) {
//
//        if (response.isSuccessful() && response.body() != null){
//        corvidSummery = response.body();
//        System.out.println("Response "+corvidSummery);
//        updateUI(corvidSummery);
//
//        }else{
//        //Toast.makeText(DashboardActivity.this,  response. , Toast.LENGTH_LONG).show();
//        }
//
//
//        }
//
//@Override
//public void onFailure(Call<CorvidSummery> call, Throwable t) {
//        Toast.makeText(DashboardActivity.this, "could not Get Data" +t.getMessage(), Toast.LENGTH_SHORT).show();
//        System.out.println("Response "+t.getMessage() + " Error "+t.getStackTrace());
//        }
//        });
