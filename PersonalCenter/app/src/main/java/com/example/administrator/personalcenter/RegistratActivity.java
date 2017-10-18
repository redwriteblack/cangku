package com.example.administrator.personalcenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.personalcenter.bean.RegistratBean;
import com.example.administrator.personalcenter.utils.StringUtils;
import com.example.administrator.personalcenter.utils.ToastShow;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/12.
 */

public class RegistratActivity extends AppCompatActivity {
    private TextView tv_abolish;//取消按钮
    private EditText et_phone;//输入手机号
    private EditText et_auth;//手机验证码
    private TextView tv_getauth;//获取验证码
    private EditText et_setpassword;//设置密码
    private EditText et_more_password;//再次设置验证码
    private Button but_registrat;//注册
    private SharedPreferences sp;
    private String phone;
    private String auth;
    private String setpassword;
    private boolean rs;
    private boolean rs1;
    private boolean rs2;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrat);


        tv_abolish = (TextView) findViewById(R.id.tv_abolish);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_auth = (EditText) findViewById(R.id.et_auth);
        et_setpassword = (EditText) findViewById(R.id.et_setpassword);
        tv_getauth = (TextView) findViewById(R.id.tv_getauth);
        et_more_password = (EditText) findViewById(R.id.et_more_password);
        but_registrat = (Button) findViewById(R.id.but_registrat);


        setback();

        jumpMain();


    }

    private void jumpMain() {
        but_registrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verify();//验证


            }
        });
    }

    private void verify() {

        phone = et_phone.getText().toString().trim();
        auth = et_auth.getText().toString().trim();
        setpassword = et_setpassword.getText().toString().trim();
        String setPhone = "[1][3,5,7,8]\\d{9}";//验证电话电话号码
        String setPsd = "[A-Za-z0-9]{6,20}";//验证密码
        String setYan = "\\d{6}";//验证码

        if (phone != null) {
            rs = phone.matches(setPhone);
        }


        if (setpassword != null) {
            rs1 = setpassword.matches(setPsd);
        }


        if (auth != null) {
            rs2 = auth.matches(setYan);
        }


        if (!rs) {
            ToastShow.toastShow(RegistratActivity.this, "帐号输入错误");
            return;
        }
        if (!rs1) {
            ToastShow.toastShow(RegistratActivity.this, "密码输入错误");
            return;
        }
        if (!rs2) {
            ToastShow.toastShow(RegistratActivity.this, "验证码输入错误");
            return;
        }
        String more = et_more_password.getText().toString().trim();
        if (!setpassword.equals(more)) {
            ToastShow.toastShow(RegistratActivity.this, "两次输入密码不一致");

        } else if (rs && rs1 && rs2) {
            goRegistrat();
        }
    }

    private void goRegistrat() {
        sp = getSharedPreferences("token.xml", 0);

        String url = StringUtils.REGISTRAT;
        OkGo.<String>post(url)
                .params("mobile", phone)
                .params("password", setpassword)
                .params("captcha", auth)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        if (TextUtils.isEmpty(body)) {
                            ToastShow.toastShow(RegistratActivity.this, "为空");
                        }
                        Gson gson = new Gson();
                        RegistratBean registratBean = gson.fromJson(body, RegistratBean.class);
                        if (registratBean.getCode() != 200) {
                            ToastShow.toastShow(RegistratActivity.this, "请求失败");
                        }
                        String token = registratBean.getData().getToken();
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("token", token);
                        edit.commit();
                        // startActivity(new Intent(RegistratActivity.this, MainActivity.class));
                        setResult(2);
                        finish();


                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        ToastShow.toastShow(RegistratActivity.this, "请求失败");
                    }
                });
    }


    private void setback() {
        tv_abolish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistratActivity.this, LoginActivity.class));
                finish();
            }
        });
    }


    //public interface on

}


