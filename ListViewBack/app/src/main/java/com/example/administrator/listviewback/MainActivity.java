package com.example.administrator.listviewback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_first;
    private MyBaseAdapter myBaseAdapter;
    private ArrayList<GoodsCarBean> list;
    private ImageView cb_checkde_all;
    private boolean ischecked = false;
    private TextView tv_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        lv_first = (ListView) findViewById(R.id.lv_first);
        cb_checkde_all = (ImageView) findViewById(R.id.iv_status_all);
        tv_price = (TextView) findViewById(R.id.tv_price);

        for (int i = 0; i < 20; i++) {
            GoodsCarBean goodsCarBean = new GoodsCarBean();
            goodsCarBean.name = "商品" + i;
            goodsCarBean.price = (100 + i) + "";
            if (i % 3 == 0) {
                goodsCarBean.status = true;
            } else {
                goodsCarBean.status = false;

            }

            list.add(goodsCarBean);

        }
        myBaseAdapter = new MyBaseAdapter(this, list);


        myBaseAdapter.setOnDataChangeListener(new MyBaseAdapter.OnDataChangeListener() {
            @Override
            public void dataChange(ArrayList<GoodsCarBean> list) {
                setTotalPrice(list);
            }
        });


        lv_first.setAdapter(myBaseAdapter);
        cb_checkde_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ischecked) {
                    for (GoodsCarBean gs : list) {
                        gs.status = false;
                    }
                    myBaseAdapter.notifyDataSetChanged();


                    //cb_checkde_all.setImageResource(R.mipmap.bb);

                } else {
                    for (GoodsCarBean gs : list) {
                        gs.status = true;
                    }
                    myBaseAdapter.notifyDataSetChanged();


                    //cb_checkde_all.setImageResource(R.mipmap.aa);

                }
                ischecked = !ischecked;

                setTotalPrice(list);
            }
        });

        setTotalPrice(list);
    }

    public void setTotalPrice(ArrayList<GoodsCarBean> list){
            int totalPrice = 0;
            int totalCheckedsize = 0;
        for (GoodsCarBean gb : list) {
            if (gb.status) {
                int price = Integer.parseInt(gb.price);
                totalPrice += price;
                totalCheckedsize++;
            }
        }

        tv_price.setText(totalPrice+"");
        if (totalCheckedsize == list.size()) {
            cb_checkde_all.setImageResource(R.mipmap.aa);
        } else {
            cb_checkde_all.setImageResource(R.mipmap.bb);
        }


    }
}
