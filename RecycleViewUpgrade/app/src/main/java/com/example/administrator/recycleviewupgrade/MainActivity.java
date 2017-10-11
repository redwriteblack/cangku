package com.example.administrator.recycleviewupgrade;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.recycleviewupgrade.adapter.MyAdapterOne;
import com.example.administrator.recycleviewupgrade.adapter.MyRecyclerAdapter;
import com.example.administrator.recycleviewupgrade.line.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_test;
    private SwipeRefreshLayout sr_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_test = (RecyclerView) findViewById(R.id.rv_test);
        sr_add = (SwipeRefreshLayout) findViewById(R.id.sr_add);


        final ArrayList<String> list = new ArrayList<>();

        for (int i = 0;i < 10;i++) {
            list.add("侏罗纪"+i);
        }



            //主布局
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_test.setLayoutManager(linearLayoutManager);
        final MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this ,list);



        sr_add.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.add(0,"这是刷新出来的");
                myRecyclerAdapter.notifyDataSetChanged();
                sr_add.setRefreshing(false);
            }
        });

        rv_test.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST)
        );




        rv_test.setAdapter(myRecyclerAdapter);




    }
}
