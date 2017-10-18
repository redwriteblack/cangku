package test.demo.dahua.com.testviewgroup;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyFlowLayout mfl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfl = (MyFlowLayout) findViewById(R.id.mfl);
        mfl.setHor(40);
        mfl.setVer(20);
        ArrayList<String> strings = new ArrayList<>();
        for(int i=0;i<30;i++){
            strings.add(i + "");

        }

        mfl.setDataSource(strings);

      /* //for (int i = 0; i < 5; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.text, mfl, false);
            TextView tv_aa = (TextView) view.findViewById(R.id.tv_aa);
            tv_aa.setText("这个帽子室友带上很丑,我很满意");
            mfl.addView(view);

        View view01 = LayoutInflater.from(this).inflate(R.layout.text, mfl, false);
        TextView tv_aa01 = (TextView) view01.findViewById(R.id.tv_aa);
        tv_aa01.setText("我和我的小伙伴极为满意");
        mfl.addView(view01);



        View view02 = LayoutInflater.from(this).inflate(R.layout.text, mfl, false);
        TextView tv_aa02 = (TextView) view02.findViewById(R.id.tv_aa);
        tv_aa02.setText("我感觉一般满意");
        mfl.addView(view02);


        View view03 = LayoutInflater.from(this).inflate(R.layout.text, mfl, false);
        TextView tv_aa03 = (TextView) view03.findViewById(R.id.tv_aa);
        tv_aa03.setText("波波宿舍的有两大法器,波波的舍友一直不舍得扔");
        mfl.addView(view03);

        View view04 = LayoutInflater.from(this).inflate(R.layout.text, mfl, false);
        TextView tv_aa04 = (TextView) view04.findViewById(R.id.tv_aa);
        tv_aa04.setText("波波宿舍的有两大法器");
        mfl.addView(view04);

*/
           /* TextView textView = new TextView(this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(60,40);


            textView.setLayoutParams(layoutParams);
            textView.setText("");
            textView.setBackgroundColor(Color.parseColor("#0000ff"));*/

       // }
    }
}
