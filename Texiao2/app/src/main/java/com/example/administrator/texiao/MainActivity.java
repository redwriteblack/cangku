package com.example.administrator.texiao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.texiao.adapter.MainRVAdapter;
import com.example.administrator.texiao.adapter.MyAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabs;
    private RecyclerView rv_01;
    private ArrayList<String> strs;
    private MainRVAdapter adapter;
    private ViewPager viewpager;

    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabs = (TabLayout) findViewById(R.id.tabs);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        list = new ArrayList<>();
        list.add("富强");
        list.add("民主");
        list.add("和谐");


        MyAdapter myadapter = new MyAdapter(this,list);
        viewpager.setAdapter(myadapter);
        tabs.setupWithViewPager(viewpager);


    }
}
