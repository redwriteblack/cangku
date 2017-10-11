package com.example.administrator.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.recyclerviewtest.adapter.MyRecylerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_test = (RecyclerView) findViewById(R.id.rv_test);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试数据" + i);
        }

        //竖直方向的RecylerViewtest，要想改变方向只用改变方向即可
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_test.setLayoutManager(linearLayoutManager);

        MyRecylerViewAdapter myRecylerViewAdapter = new MyRecylerViewAdapter(this, list);
        rv_test.setAdapter(myRecylerViewAdapter);

       /* GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);

        rv_test.setLayoutManager(gridLayoutManager);

        MyRecylerViewAdapter myRecylerViewAdapter = new MyRecylerViewAdapter(this, list);
        rv_test.setAdapter(myRecylerViewAdapter);*/

    }
}
