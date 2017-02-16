package com.greencross.fitness.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

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
