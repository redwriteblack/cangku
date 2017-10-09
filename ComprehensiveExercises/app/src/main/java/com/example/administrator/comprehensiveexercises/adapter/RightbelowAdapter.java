package com.example.administrator.comprehensiveexercises.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.comprehensiveexercises.jsonbean.DrugRightBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */

public class RightbelowAdapter extends RecyclerView.Adapter<RightbelowAdapter.MyHolder> {
    private Context context;
    private List<DrugRightBean.DataBean> dataBeen;

    public RightbelowAdapter(Context context, List<DrugRightBean.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }


}
