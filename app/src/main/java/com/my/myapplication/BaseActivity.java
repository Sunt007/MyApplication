package com.my.myapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/19.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        int layout = getContentViewLayoutResources();
        if (layout != 0) {
            setContentView(layout);
            ButterKnife.bind(this);
        }
        initResource(savedInstanceState);
    }

    /**
     * 获取内容布局
     *
     * @return 布局资源ID
     */
    protected abstract int getContentViewLayoutResources();

    /**
     * 初始化
     */
    protected abstract void initResource(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
