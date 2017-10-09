package com.example.administrator.texiao.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.texiao.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/23.
 */

public class MyAdapter extends PagerAdapter {
    private RecyclerView rv_01;
    private Context context;
    private ArrayList<String> strs;
    private MainRVAdapter adapter;
    private ArrayList<String> list;

    public MyAdapter(Context context ,ArrayList<String> list ) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, null);

        strs = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            strs.add("测试文字" + i);
        }

        rv_01 = (RecyclerView) view.findViewById(R.id.rv_01);
        LinearLayoutManager lm = new LinearLayoutManager(context);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_01.setLayoutManager(lm);
        adapter = new MainRVAdapter(context, strs);

        rv_01.setAdapter(adapter);



        container.addView(view);


        return view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
