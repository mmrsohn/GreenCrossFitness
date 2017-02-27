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
 * 아이디 찾기
 */

public class FindIdFragment extends Fragment {

    private static BaseActivity.IContent mIContent;


    public static Fragment newInstance(BaseActivity.IContent iContent) {
        FindIdFragment fragment = new FindIdFragment();
        mIContent = iContent;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_id_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        view.findViewById(R.id.find_id_complete_btn).setOnClickListener(mOnClickListener);
        view.findViewById(R.id.find_pwd_button).setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (R.id.find_id_complete_btn == vId) {
                if (mIContent != null)
                    mIContent.setFragment(LoginFragment.newInstance(mIContent));
            } else if (R.id.find_pwd_button == vId) {
                if (mIContent != null)
                    mIContent.setFragment(FindPwdFragment.newInstance(mIContent));
            }
        }
    };

}
