package com.greencross.fitness;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MrsWin on 2017-02-16.
 */

public class CommonActionBar extends View {
    public CommonActionBar(Context context) {
        super(context);
        init(context);
    }

    public CommonActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CommonActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

//    public CommonActionBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    private void init(Context context) {
        inflate(context, R.layout.common_action_bar, null);
    }
}
