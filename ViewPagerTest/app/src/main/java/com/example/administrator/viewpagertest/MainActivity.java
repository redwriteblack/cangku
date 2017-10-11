package com.example.administrator.viewpagertest;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.viewpagertest.adapter.MyAdapter;
import com.example.administrator.viewpagertest.dppxutil.PXDPUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp_page;
    private List<String> imgs;
    private LinearLayout ll_switch;
    private int dp_10;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int currentItem = vp_page.getCurrentItem();
                    vp_page.setCurrentItem(currentItem+1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_switch = (LinearLayout) findViewById(R.id.ll_switch);
        dp_10 = PXDPUtil.dp2px(this,10);

        vp_page = (ViewPager) findViewById(R.id.vp_page);


        imgs = new ArrayList<>();

        imgs.add("http://2t.5068.com/uploads/allimg/150401/1-150401092452.jpg");
        imgs.add("http://img3.imgtn.bdimg.com/it/u=2337830866,2192068839&fm=27&gp=0.jpg");
        imgs.add("http://img5.imgtn.bdimg.com/it/u=1932327444,1292631323&fm=27&gp=0.jpg");
        imgs.add("http://img1.imgtn.bdimg.com/it/u=240560108,2120586659&fm=27&gp=0.jpg");



        MyAdapter myAdapter = new MyAdapter(this, imgs);



        vp_page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                change(position%imgs.size());
                Message msg = handler.obtainMessage();
                msg.what=1;
                handler.sendMessageDelayed(msg, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==ViewPager.SCROLL_STATE_DRAGGING){
                    handler.removeCallbacksAndMessages(null);
                }

            }
        });
        for (int i = 0; i<imgs.size();i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dp_10, dp_10);
            params.leftMargin = dp_10*2;
            imageView.setLayoutParams(params);
            imageView.setBackgroundColor(Color.parseColor("#88FFFFFF"));
            ll_switch.addView(imageView);
        }


            vp_page.setAdapter(myAdapter);
            vp_page.setCurrentItem(imgs.size()*50);

            change(0);

    }

    private void change(int position) {
        for (int i = 0 ; i<imgs.size();i++) {
            ImageView iv = (ImageView) ll_switch.getChildAt(i);
            if (i == position) {
                iv.setBackgroundColor(Color.parseColor("#88FF0000"));
            } else {
                iv.setBackgroundColor(Color.parseColor("#88FFFFFF"));
            }

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
