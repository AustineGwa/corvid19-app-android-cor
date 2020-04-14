package com.geeksarena.afyayangu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geeksarena.afyayangu.R;


public class UserIntroFragment extends Fragment {

    private TextView textView;
    private String message;

    public UserIntroFragment(String message) {
        this.message = message;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_intro, container, false);
        textView = view.findViewById(R.id.description_tv);

        textView.setText(message);

        return view;
    }
}
