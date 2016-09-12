package com.android.xxnan.daynews.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/5.
 */
public class OkManagerUtil {


    private static OkManagerUtil instance;

    private OkHttpClient okHttpClient;

    public static OkManagerUtil getInstance() {
        if (instance == null) {
            synchronized (OkManagerUtil.class) {
                if (instance == null)
                    instance = new OkManagerUtil();
            }
        }
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private OkManagerUtil() {
        if (okHttpClient == null)
            okHttpClient = new OkHttpClient();
    }

    /**
     * 加载图片
     *
     * @param path
     * @param iBitmapBack
     */
    public void loadBitmap(String path, final IBitmapBack iBitmapBack) {

        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    byte[] data = response.body().bytes();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    iBitmapBack.bitmapBack(bitmap);
                }
            }
        });
    }

    /**
     * 加载知乎数据
     *
     * @param path
     * @param iDataBack
     */
    public void loaddata(String path, final IDataBack iDataBack) {

        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String data = response.body().string();
                    iDataBack.dataBack(data);
                }
            }
        });
    }

    public interface IDataBack {
        void dataBack(String data);
    }

    public interface IBitmapBack {
        void bitmapBack(Bitmap bitmap);
    }

    /**
     * 加载网易新闻数据
     *
     * @param path
     */
    public void loadNewsData(String path,final IDataBack iDataBack) {
        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String data = response.body().string();
                    System.out.print(data);
                    iDataBack.dataBack(data);
                }
            }
        });
    }

}