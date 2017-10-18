package test.demo.dahua.com.testfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import test.demo.dahua.com.testfragment.adapter.FirstVPAdapter;
import test.demo.dahua.com.testfragment.util.PXDPUtil;

/**
 * Created by dragon on 2017/9/19.
 */

public class FirstActivity extends AppCompatActivity {
    private ViewPager vp_head;
    private ArrayList<String> imgs;
    private LinearLayout ll_circles;
    private int dp_10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);
        ll_circles = (LinearLayout) findViewById(R.id.ll_circles);
        dp_10 = PXDPUtil.dp2px(this, 10);

        imgs = new ArrayList<>();
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505824978020&di=c731a65bc1408c01fee539f1d80ad6e1&imgtype=jpg&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8694a4c27d1ed21b95673424a46eddc450da3f40.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505825000832&di=3a053a5ede2c8a837207bb5bb75660de&imgtype=jpg&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcc11728b4710b9128942bd3ecafdfc039345226a.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505824971348&di=d58e11f876d8fa4eb63cfe9aa7d36468&imgtype=jpg&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F1b4c510fd9f9d72ad30cb6dcdd2a2834359bbb83.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505824968302&di=44d5d881cb6930d9b8facedf1ff1c955&imgtype=0&src=http%3A%2F%2Fpic37.nipic.com%2F20140209%2F8821914_160358483120_2.jpg");

        vp_head = (ViewPager) findViewById(R.id.vp_head);
        FirstVPAdapter vpAdapter = new FirstVPAdapter(this,imgs);

        vp_head.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeCircle(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        for(int i=0;i<imgs.size();i++){
            ImageView iv = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp_10,dp_10);

            layoutParams.leftMargin=dp_10*2;


            iv.setLayoutParams(layoutParams);
            iv.setBackgroundColor(Color.parseColor("#ff0000"));


            ll_circles.addView(iv);

        }


        vp_head.setAdapter(vpAdapter);

        changeCircle(0);


    }

    public void changeCircle(int pos){

        for(int i=0;i<imgs.size();i++){
            ImageView iv = (ImageView) ll_circles.getChildAt(i);
            if(i==pos){
               iv.setBackgroundColor(Color.parseColor("#aa0000ff"));
            }else{
                iv.setBackgroundColor(Color.parseColor("#aaFF0000"));

            }
        }

    }



}
