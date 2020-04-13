package com.geeksarena.afyayangu.views.general;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.geeksarena.afyayangu.R;
import com.google.firebase.auth.FirebaseAuth;

public class Splash extends Activity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI();
    }

    private void updateUI() {
        Thread thread  = new Thread(){

            @Override
            public  void run(){
                try {


                    Thread.sleep(1000);
                    startLogin();



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void startLogin() {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

  }
