package com.example.administrator.listview;

import android.content.Context;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/9/8.
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsCarBeen> list;


    public MyBaseAdapter(Context context, ArrayList<GoodsCarBeen> list) {
        this.context = context;
        this.list = list;
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

//        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false1);
//        TextView tv = (TextView) view.findViewById(R.id.tv_first);
//        tv.setText(list.get(position));

        ViewHolder holder ;

        final GoodsCarBeen goodsCarBeen = list.get(position);


        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.tv_name);
            holder.isChecked = (CheckBox) convertView.findViewById(R.id.cb_state);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goodsCarBeen.isChecked = isChecked;
                notifyDataSetChanged();
            }
        });
        if (goodsCarBeen.isChecked == true) {

        }else{

        }




        holder.textView.setText(goodsCarBeen.name);
        holder.isChecked.setChecked(goodsCarBeen.isChecked);





        return convertView;

    }

    static class ViewHolder {
        public TextView textView;
        public CheckBox isChecked;


    }
}
