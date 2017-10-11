package com.example.administrator.xrecycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.xrecycleview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/10.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context context;




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View text = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);

        return new MyViewHolder(text);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_first;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_first = (TextView) itemView.findViewById(R.id.tv_first);
        }
    }
}
