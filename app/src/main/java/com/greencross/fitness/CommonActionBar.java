package com.greencross.fitness;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

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
        inflate(context, R.layout.custom_action_bar, null);
        setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
    }
}
