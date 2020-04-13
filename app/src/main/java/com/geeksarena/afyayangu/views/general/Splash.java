package com.geeksarena.afyayangu.views.general;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.geeksarena.afyayangu.R;
import com.google.firebase.auth.FirebaseAuth;

public class Splash extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String prevStarted = "prevStarted";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
            Intent intent = new Intent(this, IntroActivity.class);

            updateUI(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);


            updateUI(intent);


        }

    }

    private void updateUI(Intent intent) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {


                    Thread.sleep(1000);
                    startLogin(intent);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void startLogin(Intent intent) {

        startActivity(intent);
        finish();
    }

}
