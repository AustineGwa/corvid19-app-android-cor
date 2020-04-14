package com.geeksarena.afyayangu.views.general;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.adapters.IntroViewPagerAdapter;

public class IntroActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private FragmentStateAdapter fragmentStateAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager2 = findViewById(R.id.intro_viewpager);
        fragmentStateAdapter = new IntroViewPagerAdapter(this);
        viewPager2.setAdapter(fragmentStateAdapter);
        button = findViewById(R.id.skip_button);

    }


    @Override
    protected void onStart() {
        super.onStart();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipSlides();
            }
        });
    }


    void skipSlides(){
        startActivity(new Intent(this, LoginActivity.class));

    }
}
