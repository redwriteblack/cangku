package com.example.administrator.personalcenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.personalcenter.bean.Loginbean;
import com.example.administrator.personalcenter.utils.StringUtils;
import com.example.administrator.personalcenter.utils.ToastShow;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * Created by Administrator on 2017/10/12.
 */

public class LoginActivity extends AppCompatActivity {
    private TextView tv_registrat;//注册
    private EditText et_mobile;//输入帐号
    private EditText et_password;//输入密码
    private Button but_login;//登陆按钮
    private ImageView im_rempassword; //记住密码
    private ImageView iv_back;//后退键

    private SharedPreferences  sp;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_registrat = (TextView) findViewById(R.id.tv_registrat);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_password = (EditText) findViewById(R.id.et_password);
        but_login = (Button) findViewById(R.id.but_login);
        im_rempassword = (ImageView) findViewById(R.id.im_rempassword);
        iv_back = (ImageView) findViewById(R.id.iv_back);


        jump();


        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uptop();
            }
        });


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }

    private void uptop() {
        String username = et_mobile.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        sp = getSharedPreferences("token.xml",0);
        String url = StringUtils.LOGINMSG;
        OkGo.<String>post(url)
                .params("mobile",username)
                .params("password",password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        ToastShow.toastShow(LoginActivity.this,"请求成功");
                        String body = response.body();
                        if (TextUtils.isEmpty(body)) {
                            ToastShow.toastShow(LoginActivity.this,"为空");
                        }

                        Gson gson = new Gson();
                        Loginbean loginbean = gson.fromJson(body, Loginbean.class);
                        if (loginbean.getCode() != 200) {
                            ToastShow.toastShow(LoginActivity.this, "请求失败");
                        } else {

                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("token", loginbean.getData().getToken());
                            editor.commit();
                            finish();
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                        ToastShow.toastShow(LoginActivity.this, "请求失败");
                    }
                });
    }

    private void jump() {
        tv_registrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistratActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode==2) {

                }


                break;

        }
    }
}
