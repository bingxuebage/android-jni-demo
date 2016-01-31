package com.example.jungou.jnitest;

/**
 * Created by jungou on 2016/1/28 0028.
 */
public class JniApi {
    static {
        System.loadLibrary("jesonlib");
    }

    public native String getTitle();
}
