package com.example.administrator.recycleviewupgrade.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.recycleviewupgrade.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/14.
 */

public class MyAdapterOne extends RecyclerView.Adapter<MyAdapterOne.ViewHolder> {
    private Context context;


    public MyAdapterOne(Context context) {
        this.context = context;

    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_second_one, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textview.setText("测试数据"+position);

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        public ViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.tv_logo_one);

        }


    }




}
