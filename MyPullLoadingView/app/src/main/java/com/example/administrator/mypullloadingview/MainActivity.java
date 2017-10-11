package com.example.administrator.mypullloadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PullLoadingView pld;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pld = (PullLoadingView) findViewById(R.id.pld);


        strings = new ArrayList<>();
        for (int i = 0 ; i<20;i++) {
            strings.add("测试"+i);
        }




        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pld.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(this,strings);
        pld.setAdapter(adapter);


    }
}
