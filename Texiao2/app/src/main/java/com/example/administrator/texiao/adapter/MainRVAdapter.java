package com.example.administrator.texiao.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.texiao.R;

import java.util.ArrayList;



/**
 * Created by dragon on 2017/9/21.
 */

public class MainRVAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<String> strs;

    public MainRVAdapter(Context context, ArrayList<String> strs) {
        this.context = context;
        this.strs = strs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.main_rv02, parent, false);
                return new ImageHolder(view);



            case 1:
                View itemView = LayoutInflater.from(context).inflate(R.layout.item_rv_main, parent, false);

                return new MainHolder(itemView);

            default:
                return null;

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position!=0){
            MainHolder mainHolder = (MainHolder) holder;
            mainHolder.rv_rv.setText(strs.get(position-1));
        }


    }

    @Override
    public int getItemCount() {
        return strs.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
       if(position==0){
           return 0;
       }else{
           return  1;
       }
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;

        public ImageHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_head);
        }
    }


    class MainHolder extends RecyclerView.ViewHolder{


        TextView rv_rv;
        public MainHolder(View itemView) {
            super(itemView);
            rv_rv = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
