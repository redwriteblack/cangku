package com.example.administrator.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttest.fragment.AppFragment;
import com.example.administrator.fragmenttest.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_all;

    private RadioButton rb_home;
    private TextView tv_math;
    private HomeFragment homeFragment;

    private AppFragment appFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_all = (RadioGroup) findViewById(R.id.rg_all);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        tv_math = (TextView) findViewById(R.id.tv_math);


        rg_all.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        checked();
                        break;

                    case R.id.rb_app:
                        checkapp();
                        break;

                    case R.id.rb_game:

                        break;

                    case R.id.rb_manger:

                        break;

                }
            }
        });

        rb_home.performClick();

    }

    private void checkapp() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (appFragment == null) {
            appFragment = new AppFragment();
            fragmentTransaction.add(R.id.fl_rcplace, appFragment);
        }
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }

        fragmentTransaction.show(appFragment);
        fragmentTransaction.commit();






    }

    private void checked() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            homeFragment.setOnbuttonChecklistener(new HomeFragment.OnbuttonChecklistener() {
                @Override
                public void buttonCheck(int i) {
                    tv_math.setText(i+"");
                }
            });

            Bundle bundle = new Bundle();
            bundle.putString("count","我是数据一");


            homeFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.fl_rcplace, homeFragment);

        }

        if (appFragment != null) {
            fragmentTransaction.hide(appFragment);
        }
        fragmentTransaction.show(homeFragment);
        fragmentTransaction.commit();









    }
    /*public void tvSet(String info){
        tv_math.setText(info);
    }*/

    public void setTvtest(String s){
        if (homeFragment == null) {
            return;
        }
        homeFragment.setTest(s);
    }







}
