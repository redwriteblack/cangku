package com.example.administrator.listviewback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12.
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsCarBean> list;
    OnDataChangeListener onDataChangeListener;

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }



    public MyBaseAdapter( Context context,ArrayList<GoodsCarBean> list) {
        this.context = context;
        this.list = list;
    }

    interface OnDataChangeListener{
        void  dataChange(ArrayList<GoodsCarBean> list);
    }







    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GoodsCarBean goodsCarBean = list.get(position);
        final MyViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }


        holder.iv_status.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (goodsCarBean.status) {
                    holder.iv_status.setImageResource(R.mipmap.bb);
                } else {
                    holder.iv_status.setImageResource(R.mipmap.aa);

                }
                goodsCarBean.status = !goodsCarBean.status;
                if (onDataChangeListener != null) {
                    onDataChangeListener.dataChange(list);
                }
            }


        });





        if (goodsCarBean.status) {
            holder.iv_status.setImageResource(R.mipmap.aa);
        } else {
            holder.iv_status.setImageResource(R.mipmap.bb);

        }

        holder.tv_name.setText(goodsCarBean.name);
        holder.tv_price.setText(goodsCarBean.price);
       // holder.iv_status.setChecked(goodsCarBean.status);
        return convertView;
    }

    class MyViewHolder{
        private ImageView iv_status;
        private TextView tv_name;
        private TextView tv_price;
        public MyViewHolder(View view){
            iv_status = (ImageView) view.findViewById(R.id.iv_status);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_price = (TextView) view.findViewById(R.id.tv_price);

        }





    }
}
