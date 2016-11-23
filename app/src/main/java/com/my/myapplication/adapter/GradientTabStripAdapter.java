package com.my.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;

import com.my.myapplication.R;
import com.my.myapplication.fragments.PenFragment;
import com.my.myapplication.fragments.SearchFragment;
import com.my.myapplication.fragments.UserFragment;
import com.my.myapplication.fragments.BookFragment;

import am.widget.gradienttabstrip.GradientTabStrip;

/**
 * GradientTabStripAdapter
 * Created by Alex on 2016/5/19.
 */
public class GradientTabStripAdapter extends FragmentPagerAdapter implements
        GradientTabStrip.GradientTabAdapter {

    public GradientTabStripAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
            case 0:
                return new BookFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new UserFragment();
            case 3:
                return new PenFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "练习";
            case 1:
                return "刷题  ";
            case 2:
                return "搜题";
            case 3:
                return "我的";
        }
    }

    @Override
    public Drawable getNormalDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.book);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.pen);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.search);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.user);
        }
    }

    @Override
    public Drawable getSelectedDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.book_fill);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.pen_fill);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.search_fill);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.user_fill);
        }
    }

    @Override
    public boolean isTagEnable(int position) {
        //return position != 3;
        return position == -1;
    }

    @Override
    public String getTag(int position) {
        switch (position) {
            default:
            case 0:
                return "888";
            case 1:
                return "";
            case 2:
                return "new";
        }
    }
}
