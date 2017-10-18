package com.example.administrator.personalcenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.personalcenter.bean.UserMsgbean;
import com.example.administrator.personalcenter.utils.StringUtils;
import com.example.administrator.personalcenter.utils.ToastShow;
import com.example.administrator.personalcenter.view.CircleImageView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_setting;//设置
    private TextView tv_username;//用户得到的姓名
    private TextView tv_usergrade;//用户名下的积分
    private LinearLayout ll_usergrade;//我的积分
    private LinearLayout ll_usercollect;//我的收藏
    private LinearLayout ll_userindent;//我的订单
    private LinearLayout ll_userpocket;//我的口袋
    private LinearLayout ll_usercase;//我的病例
    private LinearLayout ll_site;//收货地址
    private LinearLayout ll_withme;//关于我们
    private Button but_backlogin;//退出登录
    private CircleImageView iv_userimg;//头像
    private Button but_etmake;//et的使用

    private LinearLayout ll_in;//里边的线行布局
    private TextView tv_mylogin;//相对布局里面的注册登录
    //0正在请求网络 1请求失败 2请求成功
    int status = 0;


    private SharedPreferences sp;
    private String token;
    private SharedPreferences sp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_setting = (ImageView) findViewById(R.id.iv_setting);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_usergrade = (TextView) findViewById(R.id.tv_usergrade);
        ll_usergrade = (LinearLayout) findViewById(R.id.ll_usergrade);
        ll_usercollect = (LinearLayout) findViewById(R.id.ll_usercollect);
        ll_userindent = (LinearLayout) findViewById(R.id.ll_userindent);
        ll_userpocket = (LinearLayout) findViewById(R.id.ll_userpocket);
        ll_usercase = (LinearLayout) findViewById(R.id.ll_usercase);
        ll_site = (LinearLayout) findViewById(R.id.ll_site);
        ll_withme = (LinearLayout) findViewById(R.id.ll_withme);
        but_backlogin = (Button) findViewById(R.id.but_backlogin);
        but_etmake = (Button) findViewById(R.id.but_etmake);
        iv_userimg = (CircleImageView) findViewById(R.id.iv_userimg);

        ll_in = (LinearLayout) findViewById(R.id.ll_in);
        tv_mylogin = (TextView) findViewById(R.id.tv_mylogin);

        setChecked();


        but_etmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DomeActivity.class ));


            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        sp = getSharedPreferences("token.xml", 0);
        token = sp.getString("token", "");
        getUserData();


    }

    private void getUserData() {

            String url = StringUtils.MSG;
            OkGo.<String>get(url)
                    .params("token", token)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            Log.e("token+++++++++", "onCreate: ++++++++++++++++++++++++++22222222222==" + token);
                            String body = response.body();
                            if (TextUtils.isEmpty(body)) {
                                status=1;
                                ToastShow.toastShow(MainActivity.this, "为空");

                            }
                            Gson gson = new Gson();
                            UserMsgbean userMsgbean = gson.fromJson(body, UserMsgbean.class);
                            /*if (TextUtils.isEmpty(userMsgbean.getData().getUsername())) {

                            }*/
                            if (userMsgbean.getData().getUsername().endsWith("游客")) {
                                ToastShow.toastShow(MainActivity.this, "请求失败");
                                status = 1;
                                tv_mylogin.setVisibility(View.VISIBLE);
                                ll_in.setVisibility(View.INVISIBLE);

                            } else {
                                ToastShow.toastShow(MainActivity.this, "请求成功");
                                status =2;
                                tv_mylogin.setVisibility(View.INVISIBLE);
                                ll_in.setVisibility(View.VISIBLE);


                                tv_username.setText(userMsgbean.getData().getUsername());
                                tv_usergrade.setText("积分 ：" + userMsgbean.getData().getIntegral());
                                GlideApp.with(MainActivity.this)
                                        .load(StringUtils.INDS + userMsgbean.getData().getAvatar())
                                        .into(iv_userimg);


                            }

                        }

                        @Override
                        public void onError(Response<String> response) {

                            super.onError(response);
                            ToastShow.toastShow(MainActivity.this, "请求失败");
                            status =1;
                            tv_mylogin.setVisibility(View.VISIBLE);
                            ll_in.setVisibility(View.INVISIBLE);

                        }
                    });
        }




    private void setChecked() {
        iv_setting.setOnClickListener(this);
        ll_usergrade.setOnClickListener(this);
        ll_usercollect.setOnClickListener(this);
        ll_userindent.setOnClickListener(this);
        ll_userpocket.setOnClickListener(this);
        ll_usercase.setOnClickListener(this);
        ll_site.setOnClickListener(this);
        ll_withme.setOnClickListener(this);
        but_backlogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        //sp = getSharedPreferences("token.xml", 0);
        //token = sp.getString("token", "");
       /* Log.e("token+++++++++", "onCreate: ++++++++++++++++++++++++++333333333==" + token);
        if (TextUtils.isEmpty(token)) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {}*/
            switch (v.getId()) {

                case R.id.iv_setting:
                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "设置");
                    }



                    break;

                case R.id.ll_usergrade:
                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "我的积分");
                    }


                    break;

                case R.id.ll_usercollect:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "我的收藏");
                    }

                    break;

                case R.id.ll_userindent:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "我的订单");
                    }

                    break;

                case R.id.ll_userpocket:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "我的口袋");
                    }

                    break;

                case R.id.ll_usercase:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "我的病例");
                    }

                    break;

                case R.id.ll_site:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "收货地址");
                    }

                    break;

                case R.id.ll_withme:

                    if (status == 0) {
                        return;
                    }else if (status ==1) {
                        startActivity(new Intent(this, LoginActivity.class));
                    } else if (status ==2) {
                        ToastShow.toastShow(MainActivity.this, "关于我们");
                    }

                    break;
                case R.id.but_backlogin:
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("token", "");

                    edit.commit();
                    tv_username.setText("消除了");
                    tv_usergrade.setText("消除了");

                    break;


            }

    }
}
