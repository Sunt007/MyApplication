package com.my.myapplication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2016/11/21.
 */

public class AllGson {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonAllGson(String jsonData, Class<T> jsonType) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonData, jsonType);
        return t;
    }

    // 将Json数组解析成相应的映射对象列表
    public static <T> List<T> parseJsonArrayGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {}.getType());
        return result;
    }
}
