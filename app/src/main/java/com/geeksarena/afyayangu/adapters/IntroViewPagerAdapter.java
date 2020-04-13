package com.geeksarena.afyayangu.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.geeksarena.afyayangu.views.general.UserIntroFragment;


public class IntroViewPagerAdapter extends FragmentStateAdapter {

    UserIntroFragment userIntroFragment = new UserIntroFragment();


    public IntroViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return userIntroFragment;
        } else if (position == 1) {
            return userIntroFragment;
        } else
            return userIntroFragment;

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
