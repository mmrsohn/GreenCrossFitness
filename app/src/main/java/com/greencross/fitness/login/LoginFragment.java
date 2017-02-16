package com.greencross.fitness.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.greencross.fitness.R;

/**
 * Created by MrsWin on 2017-02-16.
 */

public class LoginFragment extends Fragment {

    private static LoginActivity.IContent mIContent;


    public static Fragment newInstance(LoginActivity.IContent iContent) {
        LoginFragment fragment = new LoginFragment();
        mIContent = iContent;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView fogotTextView = (TextView) view.findViewById(R.id.login_fogot_account_textview);
        Button loginButton = (Button) view.findViewById(R.id.login_login_button);
        CheckBox saveIdCheckBox = (CheckBox) view.findViewById(R.id.login_save_id_checkbox);
        CheckBox autoLoginCheckBox = (CheckBox) view.findViewById(R.id.login_auto_login_checkbox);
        EditText pwdEditText = (EditText) view.findViewById(R.id.login_pwd_edittext);
        EditText loginIdEditText = (EditText) view.findViewById(R.id.login_id_edittext);

        view.findViewById(R.id.login_join_button).setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (R.id.login_join_button == vId) {
                if (mIContent != null)
                    mIContent.setFragment(JoinStep1Fragment.newInstance());
            }
        }
    };

}
