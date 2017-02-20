package com.greencross.fitness.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greencross.fitness.R;

/**
 * Created by MrsWin on 2017-02-16.
 */

public class JoinStep3Fragment extends Fragment {

    private static LoginActivity.IContent mIContent;


    public static Fragment newInstance(LoginActivity.IContent iContent) {
//    public static Fragment newInstance() {
        JoinStep3Fragment fragment = new JoinStep3Fragment();
        mIContent = iContent;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.join_step3_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        view.findViewById(R.id.complete_btn).setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (R.id.complete_btn == vId) {
                if (mIContent != null)
                    mIContent.setFragment(LoginFragment.newInstance(mIContent));
            }
        }
    };
}
