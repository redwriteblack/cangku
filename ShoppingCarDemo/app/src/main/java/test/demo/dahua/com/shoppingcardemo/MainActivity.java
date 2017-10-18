package test.demo.dahua.com.shoppingcardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import test.demo.dahua.com.shoppingcardemo.bean.GoodsBean;

public class MainActivity extends AppCompatActivity {
    private ListView lv_01;
    private ImageView iv_select_all;
    private TextView tv_price;
    private MyAdapter adapter;
    private boolean isChecked = false;

    private ArrayList<GoodsBean> goodsBeens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_01 = (ListView) findViewById(R.id.lv_01);
        iv_select_all = (ImageView) findViewById(R.id.iv_select_all);
        tv_price = (TextView) findViewById(R.id.tv_price);
        goodsBeens = new ArrayList<>();
        for(int i=0;i<10;i++){
            GoodsBean gb = new GoodsBean();
            gb.name = "名字" + i;
            gb.price = (i + 10) + "";
            if (i % 3 == 0) {
                gb.isChecked = true;
            } else {
                gb.isChecked = false;
            }
            goodsBeens.add(gb);
        }

        adapter = new MyAdapter(this, goodsBeens);

        adapter.setOnDataChangeListnnner(new MyAdapter.OnDataChangeListnnner() {
            @Override
            public void dataChange(ArrayList<GoodsBean> list) {
                setToatalPrice(list);
            }
        });

        lv_01.setAdapter(adapter);

        iv_select_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked){
                    for (GoodsBean gb : goodsBeens) {
                        gb.isChecked = false;
                    }
                    adapter.notifyDataSetChanged();
                   // iv_select_all.setImageResource(R.mipmap.aa);

                }else {
                    for (GoodsBean gb : goodsBeens) {
                        gb.isChecked = true;
                    }
                    adapter.notifyDataSetChanged();
                   // iv_select_all.setImageResource(R.mipmap.bb);
                }
                isChecked = !isChecked;
                setToatalPrice(goodsBeens);

            }
        });

        setToatalPrice(goodsBeens);


    }

    public void setToatalPrice(ArrayList<GoodsBean> list) {
        int totalPrice=0;
        int totalChecked=0;

        for (GoodsBean gb : list) {
            if (gb.isChecked) {
                int price = Integer.parseInt(gb.price);
                totalPrice += price;
                totalChecked++;
            }
        }
        tv_price.setText(totalPrice + "");
        if (totalChecked == list.size()) {
            iv_select_all.setImageResource(R.mipmap.bb);
        }else{
            iv_select_all.setImageResource(R.mipmap.aa);
        }
    }
}
