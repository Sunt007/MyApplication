package com.my.myapplication.View;

/**
 * Created by ouyangshengduo on 2016/9/12.
 */
public interface UserView {

    void showJson(String s);
    void showPic(byte[] data);
    void showProgressDialog();
    void hideProgressDialog();
    void showError(String msg);

}
