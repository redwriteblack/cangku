package com.example.administrator.comprehensiveexercises.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.administrator.comprehensiveexercises.R;
import com.example.administrator.comprehensiveexercises.jsonbean.DrugRightBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class DrugRightAdapter extends RecyclerView.Adapter<DrugRightAdapter.MyViewHolder> {
    private Context context;
    private List<DrugRightBean.DataBean> data;

    public DrugRightAdapter(Context context, List<DrugRightBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }



    @Override
    public DrugRightAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_drug_count, parent, false);

        return  new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(DrugRightAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.fenlie_guanggao_img);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);

        RightbelowAdapter rightbelowAdapter = new RightbelowAdapter(context,data);
        holder.recyclerView.setAdapter(rightbelowAdapter);


    }



    @Override
    public int getItemCount() {
        return 1;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        RecyclerView recyclerView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_count_top);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_count_below);
        }
    }

}
