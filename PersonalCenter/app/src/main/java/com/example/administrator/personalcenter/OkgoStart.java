package com.example.administrator.personalcenter;

import android.app.Application;

import com.lzy.okgo.OkGo;

/**
 * Created by Administrator on 2017/10/13.
 */

public class OkgoStart extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
    }
}
