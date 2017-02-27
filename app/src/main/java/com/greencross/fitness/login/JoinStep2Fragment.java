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

public class JoinStep2Fragment extends Fragment {

    private static BaseActivity.IContent mIContent;


    public static Fragment newInstance(BaseActivity.IContent iContent) {
//    public static Fragment newInstance() {
        JoinStep2Fragment fragment = new JoinStep2Fragment();
        mIContent = iContent;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.join_step2_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        view.findViewById(R.id.next_button).setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (R.id.next_button == vId) {
                if (mIContent != null)
                    mIContent.setFragment(JoinStep3Fragment.newInstance(mIContent));
            }
        }
    };
}
