package com.geeksarena.afyayangu.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.geeksarena.afyayangu.views.general.UserIntroFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IntroViewPagerAdapter extends FragmentStateAdapter {
    private List<String> messages;


    public IntroViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        messages = new ArrayList<>();
        String message1 = "Get upto date information on corona virus updated regularly per day";
        String message2 = "Information sourced from John Hopkins CSSE";
        String message3 = "Get localized information in your country at your fingertips";
        messages.addAll(Arrays.asList(message1, message2, message3));


    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new UserIntroFragment(messages.get(position));


    }


    @Override
    public int getItemCount() {
        return messages.size();
    }
}
