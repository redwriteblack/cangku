package com.example.administrator.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<GoodsCarBeen> list;
    private ListView lv_first;
    private MyBaseAdapter myBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_first = (ListView) findViewById(R.id.lv_first);
        list = new ArrayList<>();

        for (int i = 0; i<20;i++) {
            GoodsCarBeen gcb = new GoodsCarBeen();
            gcb.name = "商品"+i;
            if (i % 3 == 0) {
                gcb.isChecked = true;

            }
            list.add(gcb);



        }
        myBaseAdapter = new MyBaseAdapter(this,list);
        lv_first.setAdapter(myBaseAdapter);

    }
}
