package com.example.administrator.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.IOException;


public class MyPlayService extends Service {
    private MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    class MyBinder extends Binder {
        public void sing() {

            outerSing();
        }

        public void next() {

            outernext();
        }


    }

    @Override
    public boolean onUnbind(Intent intent) {
        mp.release();
        mp = null;
        return super.onUnbind(intent);
    }

    private void outernext() {
        mp.stop();
        mp = new MediaPlayer();
        File f = new File(getFilesDir(), "aa.mp3");

        try {
            mp.setDataSource(f.getAbsolutePath());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void outerSing() {
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();

        mp = new MediaPlayer();
        File f = new File(getFilesDir(), "qq.mp3");

        try {
            mp.setDataSource(f.getAbsolutePath());
            mp.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
