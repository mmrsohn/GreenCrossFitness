package com.greencross.fitness.login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greencross.fitness.R;

/**
 * Created by MrsWin on 2017-02-16.
 */

public class JoinStep1Fragment extends Fragment {

    public static Fragment newInstance() {
        JoinStep1Fragment fragment = new JoinStep1Fragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.join_layout_step1, container, false);
        return view;
    }
}
