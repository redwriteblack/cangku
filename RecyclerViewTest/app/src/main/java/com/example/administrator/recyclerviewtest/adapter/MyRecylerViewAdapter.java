package com.example.administrator.recyclerviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.recyclerviewtest.R;
import com.example.administrator.recyclerviewtest.toast.ToastUtil;

import java.util.ArrayList;


public class MyRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> list;

    public MyRecylerViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View view = View.inflate(context, R.layout.item, null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new NormalHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NormalHolder normalHolder = (NormalHolder) holder;
        normalHolder.textView.setText(list.get(position));
        normalHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"点击第"+position+"个",Toast.LENGTH_SHORT).show();
                ToastUtil.showToast(context, "点击第" + position + "个");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class NormalHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NormalHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

}
