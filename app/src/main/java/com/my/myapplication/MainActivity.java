package com.my.myapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;

import com.my.myapplication.Presenter.UserPresenter;
import com.my.myapplication.View.UserView;
import com.my.myapplication.adapter.GradientTabStripAdapter;

import am.widget.basetabstrip.BaseTabStrip;
import am.widget.gradienttabstrip.GradientTabStrip;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements UserView,ViewPager.OnPageChangeListener,BaseTabStrip.OnItemClickListener {

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.gts_vp_fragments)
    ViewPager gtsVpFragments;
    @Bind(R.id.gts_gts_tabs)
    GradientTabStrip gtsGtsTabs;
    private GradientTabStripAdapter adapter;


    private ProgressDialog mProgressDialog;
    private UserPresenter userPresenter;
    private String Img = "http://a.hiphotos.baidu.com/zhidao/pic/item/a50f4bfbfbedab640bc293fbf636afc379311e5c.jpg";

    /**
     * 获取内容布局
     *
     * @return 布局资源ID
     */
    @Override
    protected int getContentViewLayoutResources() {
        return R.layout.activity_main;
    }

    @Override
    protected void initResource(Bundle savedInstanceState) {
        userPresenter = new UserPresenter(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载，请稍后..");
        adapter = new GradientTabStripAdapter(getSupportFragmentManager());
        gtsVpFragments.setAdapter(adapter);
        gtsGtsTabs.setAdapter(adapter);
        gtsVpFragments.addOnPageChangeListener(this);
        gtsGtsTabs.bindViewPager(gtsVpFragments);
        gtsGtsTabs.setOnItemClickListener(this);
        setTitle(adapter.getPageTitle(gtsVpFragments.getCurrentItem()));
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        toolbarTitle.setText(title);
    }

    @Override
    public void showJson(String s) {
        if (s != null) {
            //textView.setText(s);
        }
    }

    @Override
    public void showPic(byte[] data) {
        if (data != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        }
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.hide();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * ViewPager
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTitle(adapter.getPageTitle(gtsVpFragments.getCurrentItem()));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * Item
     * @param position
     */
    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onSelectedClick(int position) {

    }

    @Override
    public void onDoubleClick(int position) {

    }
}