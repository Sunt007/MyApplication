package com.my.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.my.myapplication.BaseActivity;
import com.my.myapplication.R;
import com.my.myapplication.adapter.TikuAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/19.
 */

public class TikuActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView title;
    @Bind(R.id.tiku_lv)
    ListView tikuLv;


    @Override
    protected int getContentViewLayoutResources() {
        return R.layout.activity_tiku;
    }

    @Override
    protected void initResource(Bundle savedInstanceState) {
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        title.setText("考试题库");
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList list = new ArrayList();
        map.put("ItemTitle", "医学类");
        map.put("ItemTitle", "财经类");
        list.add(map);

        TikuAdapter adapter = new TikuAdapter(list,TikuActivity.this);
        tikuLv.setAdapter(adapter);
    }
}
