package com.example.administrator.xrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.administrator.xrecycleview.adapter.MainAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView xrv_first;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xrv_first = (XRecyclerView) findViewById(R.id.xrv_first);


        list = new ArrayList<>();

        for (int i = 0 ; i<5; i++) {
            list.add("测试数据"+1);
        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_first.setLayoutManager(layoutManager);
        MainAdapter mainAdapter = new MainAdapter();

        xrv_first.setAdapter(mainAdapter);
    }
}
