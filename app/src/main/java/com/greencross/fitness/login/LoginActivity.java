package com.greencross.fitness.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.greencross.fitness.R;
import com.greencross.fitness.util.Logger;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = LoginFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.common_action_bar, null);

        Button actionbarrightbutton = (Button) actionbar.findViewById(R.id.action_bar_right_button);
        TextView actionbartitletextview = (TextView) actionbar.findViewById(R.id.action_bar_title_textview);

        actionbar.findViewById(R.id.action_bar_left_button).setOnClickListener(actionBarClickListener);

        actionBar.setCustomView(actionbar);

        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);

        return true;
    }

    View.OnClickListener actionBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (R.id.action_bar_left_button == vId) {
                onBackPressed();
            }

        }
    };

    private void init() {
        Fragment loginFragment = LoginFragment.newInstance(new IContent() {
            @Override
            public void setFragment(Fragment fragment) {
                replaceFragment(fragment);
            }
        });

        replaceFragment(loginFragment);
    }

    interface IContent {
        void setFragment(Fragment fragment);
    }

//    private void setFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//
////        fragmentTransaction.replace(R.id.content_layout, fragment);
//        fragmentTransaction.add(R.id.content_layout, fragment);
////        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//
////        getSupportFragmentManager()
////                .beginTransaction()
////                .replace(R.id.content_layout, fragment).commit();
//    }

    private void replaceFragment(Fragment fragment) {
        Bundle args = new Bundle();
//                args.putInt(ArticleFragment.ARG_POSITION, position);
        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_layout, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);

        transaction.commit();
        printFragmentLog();
    }

    private void printFragmentLog() {
        if (getSupportFragmentManager().getFragments() != null) {
            Logger.i(TAG, "replaceFragment.size=" + getSupportFragmentManager().getFragments().size());

            for (Fragment fg: getSupportFragmentManager().getFragments()) {
                if (fg != null)
                    Logger.i(TAG, "replaceFragment.name="+fg.toString());
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        printFragmentLog();
    }
}
