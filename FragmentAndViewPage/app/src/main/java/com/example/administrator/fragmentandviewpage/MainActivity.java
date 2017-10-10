package com.example.administrator.fragmentandviewpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.fragmentandviewpage.adapter.HomeAdapter;
import com.example.administrator.fragmentandviewpage.fragment.AssessFragment;
import com.example.administrator.fragmentandviewpage.fragment.DetailFragment;
import com.example.administrator.fragmentandviewpage.fragment.HomeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp_home;
    private ArrayList<Fragment> list;
    private TabLayout tab_title;
    private ArrayList<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp_home = (ViewPager) findViewById(R.id.vp_home);
        tab_title = (TabLayout) findViewById(R.id.tab_title);

        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new AssessFragment());
        list.add(new DetailFragment());

        data = new ArrayList<>();

        data.add("商品");
        data.add("详情");
        data.add("评价");

        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(),list,data);
        vp_home.setAdapter(homeAdapter);
        tab_title.setupWithViewPager(vp_home);
    }
}
