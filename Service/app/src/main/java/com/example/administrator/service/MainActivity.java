package com.example.administrator.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button but_next;
    private Button but_start;
    private Button but_stop;
    private Button but_close;

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyPlayService.MyBinder) service;


                myBinder.sing();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private MyPlayService.MyBinder myBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but_next = (Button) findViewById(R.id.but_next);
        but_start = (Button) findViewById(R.id.but_start);
        but_stop = (Button) findViewById(R.id.but_stop);
        but_close = (Button) findViewById(R.id.but_close);

        but_start.setOnClickListener(this);
        but_close.setOnClickListener(this);
        but_next.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_next:
                next();
                break;


            case R.id.but_start:
                start();
                break;


            case R.id.but_stop:

                break;

            case R.id.but_close:
                close();

                break;


        }
    }

    private void close() {

        Intent intent = new Intent();
        intent.setAction("com.example.administrator.service");
        unbindService(sc);
        stopService(intent);
        myBinder = null;
    }

    public void next() {
        myBinder.next();
    }

    private void start() {
        Intent intent = new Intent();
        intent.setAction("com.example.administrator.service");


        startService(intent);

        bindService(intent,sc,BIND_AUTO_CREATE );
        if (myBinder != null) {
            myBinder.sing();

        }


    }


}
