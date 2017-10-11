package com.example.administrator.mypullloadingview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/29.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<String> strings;

    public MyAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View headView = LayoutInflater.from(context).inflate(R.layout.item_pull_first, parent, false);

                return new HeadViewHolder(headView);
            case 1:
                View text = LayoutInflater.from(context).inflate(R.layout.item_pull_second, parent, false);

                return new TextHolder(text);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >=1) {
            TextHolder textHolder = (TextHolder) holder;
            textHolder.text.setText(strings.get(position-1));
        }

    }

    @Override
    public int getItemCount() {
        return strings.size()+1;
    }


    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }


    }




    class HeadViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public HeadViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_start);
        }
    }


    class TextHolder extends RecyclerView.ViewHolder {
        TextView text;
        public TextHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }


}
