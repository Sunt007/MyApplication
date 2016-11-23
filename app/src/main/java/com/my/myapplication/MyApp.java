package com.my.myapplication;

import android.app.Application;

import com.shamanland.fonticon.FontIconTypefaceHolder;


/**
 * Created by huayu on 2015/8/19.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //FontIconTypefaceHolder.init(getAssets(), "iconfont.ttf");
    }
}
