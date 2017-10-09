package com.example.administrator.comprehensiveexercises.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.comprehensiveexercises.DrugActivity;
import com.example.administrator.comprehensiveexercises.R;
import com.example.administrator.comprehensiveexercises.jsonbean.MainBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/15.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
//    private Integer[] imgs;
    private ArrayList<MainBean.DataBean> list;

    public MainRecyclerViewAdapter(Context context,ArrayList<MainBean.DataBean> list) {
        this.context = context;
//        this.imgs = imgs;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_mian,parent,false);

        return new FirstHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        FirstHolder viewHolder = (FirstHolder) holder;
       switch(list.get(position).getName()){
           case "食品":
               ((FirstHolder) holder).imageView.setImageResource(R.drawable.dafenlie_shipin);
                break;
           case "药品":
               ((FirstHolder) holder).imageView.setImageResource(R.drawable.dafenlie_yaoping);
               break;
            case "保健品":
               ((FirstHolder) holder).imageView.setImageResource(R.drawable.dafenlie_baojianp);
               break;
            case "医疗器械":
               ((FirstHolder) holder).imageView.setImageResource(R.drawable.dafenlie_yiliao);
               break;

       }

//        GlideApp.with(context).load(UrlUtils.MAIN_INFACE+list.get(position).getImg()).into(viewHolder.imageView);

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DrugActivity.class);
                intent.putExtra("ID",list.get(position).getId());
                context.startActivity(intent);
            }
        });

       /* switch (position) {
            case 0:
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, DrugActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
        }*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FirstHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public FirstHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_every);
        }
    }



}
