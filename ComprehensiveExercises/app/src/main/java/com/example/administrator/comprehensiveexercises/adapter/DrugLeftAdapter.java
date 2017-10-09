package com.example.administrator.comprehensiveexercises.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.comprehensiveexercises.R;
import com.example.administrator.comprehensiveexercises.jsonbean.DrugListBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class DrugLeftAdapter extends RecyclerView.Adapter<DrugLeftAdapter.MyViewHolder> {
    private static final String TAG = "DrugLeftAdapter";
    private Context context;
    private List<DrugListBean.DataBean> list;
    private OnDataCheckedListener onDataCheckedListener;



    public DrugLeftAdapter(Context context, List<DrugListBean.DataBean> list) {
        this.context = context;
        this.list = list;
        Log.e(TAG, "DrugLeftAdapter:++++++++++++++++ "+list.size());
    }


    public void  setOnDataCheckedListener (  OnDataCheckedListener onDataCheckedListener ){
        this.onDataCheckedListener = onDataCheckedListener;
    }

    public interface OnDataCheckedListener{
        void dataCheck(int postion);
    }


    @Override
    public DrugLeftAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_durg_select, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final DrugLeftAdapter.MyViewHolder holder, final int position) {


        DrugListBean.DataBean drugListBean = list.get(position);
        String name = drugListBean.getName();
        holder.textView.setText(name);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (onDataCheckedListener != null) {
                    onDataCheckedListener.dataCheck(position);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.rv_select_left);

        }
    }
}
