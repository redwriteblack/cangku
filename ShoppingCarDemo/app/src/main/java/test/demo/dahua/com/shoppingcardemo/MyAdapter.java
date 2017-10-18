package test.demo.dahua.com.shoppingcardemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.demo.dahua.com.shoppingcardemo.bean.GoodsBean;

/**
 * Created by dragon on 2017/9/11.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsBean>  goodsBeens;

    OnDataChangeListnnner onDataChangeListnnner;

    public void setOnDataChangeListnnner(OnDataChangeListnnner onDataChangeListnnner) {
        this.onDataChangeListnnner = onDataChangeListnnner;
    }

    interface OnDataChangeListnnner{
        void dataChange(ArrayList<GoodsBean> list);
    }


    public MyAdapter(Context context, ArrayList<GoodsBean> goodsBeens) {
        this.context = context;
        this.goodsBeens = goodsBeens;
    }

    @Override
    public int getCount() {
        return goodsBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GoodsBean goodsBean = goodsBeens.get(position);
        final MyViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goods_car, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (MyViewHolder) convertView.getTag();

        }


        holder.iv_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(goodsBean.isChecked){
                    holder.iv_state.setImageResource(R.mipmap.aa);
                }else {
                    holder.iv_state.setImageResource(R.mipmap.bb);

                }
                goodsBean.isChecked = !goodsBean.isChecked;

                if (onDataChangeListnnner != null) {
                    onDataChangeListnnner.dataChange(goodsBeens);

                }

            }
        });


        if(goodsBean.isChecked){
            holder.iv_state.setImageResource(R.mipmap.bb);
        }else{
            holder.iv_state.setImageResource(R.mipmap.aa);
        }

        holder.tv_name.setText(goodsBean.name);
        holder.tv_price.setText(goodsBean.price);








        return convertView;
    }

    class MyViewHolder {
        ImageView iv_state;
        TextView tv_name;
        TextView tv_price;
        public MyViewHolder(View itemView){
            iv_state = (ImageView) itemView.findViewById(R.id.iv_state);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);

        }
    }
}
