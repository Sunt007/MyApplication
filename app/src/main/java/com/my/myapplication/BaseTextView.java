package com.my.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/22.
 */

public class BaseTextView extends TextView {
    public BaseTextView(Context context) {
        super(context);
        initView(context);
    }

    public BaseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BaseTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        //Typeface iconfont = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
		//setTypeface(iconfont);
    }
}
