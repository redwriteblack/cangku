package com.example.administrator.texiao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.texiao.R;

import java.util.ArrayList;



/**
 * Created by dragon on 2017/9/21.
 */

public class MainRVAdapterAdapter extends RecyclerView.Adapter<MainRVAdapterAdapter.MainHolder>{
    private Context context;
    private ArrayList<String> strs;

    public MainRVAdapterAdapter(Context context, ArrayList<String> strs) {
        this.context = context;
        this.strs = strs;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_rv_main, parent,false);

        return new MainHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        holder.tv_name.setText(strs.get(position));


    }

    @Override
    public int getItemCount() {
        return strs.size();
    }

    class MainHolder extends RecyclerView.ViewHolder{
        TextView tv_name;



        public MainHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
