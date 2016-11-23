package com.my.myapplication.Presenter;

import com.my.myapplication.View.UserView;
import com.my.myapplication.model.UserModel;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ouyangshengduo on 2016/9/12.
 */
public class UserPresenter {

    private UserView userView;
    private UserModel userModel;
    public UserPresenter(UserView userView){
        this.userView = userView;
        userModel = new UserModel();

    }

    // 登录
    public void getUserLogin(final String name , final String pwd ,final String path){
        userView.showProgressDialog();
        userModel.getUserLogin(name,pwd,path).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                userView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                userView.showError(e.getMessage());
                userView.hideProgressDialog();
            }

            @Override
            public void onNext(String s) {
                userView.showJson(s);
            }
        });
    }

    // Json
    public void getUserJson(final String path){
        userView.showProgressDialog();
        userModel.getUserJson(path).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                userView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                userView.showError(e.getMessage());
                userView.hideProgressDialog();
            }

            @Override
            public void onNext(String s) {
                userView.showJson(s);
            }
        });
    }

    // 加载图片
    public void getUserImage(final String path){
        userView.showProgressDialog();
        userModel.getUserImage(path).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
            @Override
            public void onCompleted() {
                userView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                userView.showError(e.getMessage());
                userView.hideProgressDialog();
            }

            @Override
            public void onNext(byte[] bytes) {
                userView.showPic(bytes);
            }
        });
    }
}
