package com.example.kshclf1.myapplication.http;


import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

public abstract class BaseCallBack<T> extends Callback<T> {
    private Class<T> clazz;

    protected BaseCallBack(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        Log.d("ezreal",string);
        return json2Bean(string, clazz);
    }


    /**
     * 将json映射成bean对象
     *
     * @param result json字符串
     * @param clazz  bean对象字节码
     */
    private static <T> T json2Bean(String result, Class<T> clazz) {
        if (TextUtils.isEmpty(result))
            return null;
        Gson gs = new Gson();
        return gs.fromJson(result, clazz);
    }
}
