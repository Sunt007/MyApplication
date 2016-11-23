package com.my.myapplication.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * BookFragment
 * Created by Alex on 2016/5/19.
 */
public class BookFragment extends Fragment {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.fgb_tv_content);
        textView.setText("111111111111");
        Drawable drawable = getResources().getDrawable(R.drawable.white_dot);
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0,0,drawable.getMinimumWidth(), drawable.getMinimumHeight());

        toolbarTitle.setText("会计基础");
        toolbarTitle.setCompoundDrawables(null, null, drawable, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
