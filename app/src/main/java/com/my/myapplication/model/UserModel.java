package com.my.myapplication.model;

import android.nfc.FormatException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by ouyangshengduo on 2016/9/12.
 */
public class UserModel {

    private OkHttpClient client;
    public UserModel(){
        client = new OkHttpClient();
    }

    // 验证
    public Observable<String> getUserLogin(final String name , final String pwd ,final String path){
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                RequestBody formBody = new FormBody.Builder().add("username",name).add("pwd",pwd) .build();
                Request request = new Request.Builder().url(path).post(formBody).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            String data = response.body().string();
                            if(data != null){
                                subscriber.onNext(data);
                            }
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }

    // Json加载
    public Observable<String> getUserJson(final String path){
        return Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                Request request = new Request.Builder().url(path).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            String data = response.body().string();
                            if(data != null){
                                subscriber.onNext(data);
                            }
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }


    // 图片加载
    public Observable<byte[]> getUserImage(final String path){
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
                Request request = new Request.Builder().url(path).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            byte [] data = response.body().bytes();
                            if(data != null){
                                subscriber.onNext(data);
                            }
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }
}
