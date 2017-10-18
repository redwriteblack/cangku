package test.demo.dahua.com.testfragment;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import test.demo.dahua.com.testfragment.fragment.HomeFragment;
import test.demo.dahua.com.testfragment.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_all;

    private RadioButton rb_home;
    private TextView tv_aa;
    private HomeFragment homeFragment;
    private MeFragment MeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_all = (RadioGroup) findViewById(R.id.rg_all);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        tv_aa = (TextView) findViewById(R.id.tv_aa);



        rg_all.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rb_home:

                        clickHome();



                        break;

                    case R.id.rb_app:

                        break;
                    case R.id.rb_game:

                        break;

                    case R.id.rb_manager:
                        clickMe();

                        break;

                }

            }
        });

        rb_home.performClick();
    }

    private void clickMe() {

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(MeFragment==null){
            MeFragment = new MeFragment();

            transaction.add(R.id.fl_content, MeFragment);

        }

        if(homeFragment!=null){
            transaction.hide(homeFragment);
        }

        transaction.show(MeFragment);
        transaction.commit();

    }

    private void clickHome() {
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(homeFragment==null){
            homeFragment = new HomeFragment();
            homeFragment.setOnButtonClickListenner(new HomeFragment.OnButtonClickListenner() {
                @Override
                public void buttonClick(int i) {
                    tv_aa.setText(i+"");

                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("str", "我是传过来的文字");
            homeFragment.setArguments(bundle);
            transaction.add(R.id.fl_content, homeFragment);

        }
      if(MeFragment!=null){
          transaction.hide(MeFragment);
      }

        transaction.show(homeFragment);

        transaction.commit();



    }

    public void setTVText(String info){
        tv_aa.setText(info);

    }


    public void setFragmentText(String info){
        if(homeFragment==null){
            return;
        }
       homeFragment.setFragmentText(info);

    }



}
