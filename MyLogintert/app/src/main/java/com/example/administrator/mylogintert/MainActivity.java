package com.example.administrator.mylogintert;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText et_uername;
    private EditText et_password;
    private Button but_register;
    private TextView tv_count;
    private EditText et_yanzheng;
    private SharedPreferences sp;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String info = (String) msg.obj;
                    tv_count.setText(info);

                    break;
                case 2:
                    String info1 = (String) msg.obj;
                    ToastUtil.showToast(MainActivity.this, info1);
                    break;
            }
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("inter.xml", 0);

        et_uername = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        but_register = (Button) findViewById(R.id.but_register);
        tv_count = (TextView) findViewById(R.id.tv_count);
        et_yanzheng = (EditText) findViewById(R.id.et_yanzheng);


        but_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        register();

                    }
                }.start();


            }
        });


    }

    private void register() {
        String name = et_uername.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String yanzheng = et_yanzheng.getText().toString().trim();
        String path = "http://192.168.1.250:8061/index.php?m=member&c=public&a=app_register&" + "mobile=" + name
                + "&password=" + password + "&captcha" + yanzheng;

        try {

            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");      //请求方式
            conn.setReadTimeout(10000);         //请求时间
            int coad = conn.getResponseCode();

            if (coad != 200) {
                ToastUtil.showToast(this, "请求失败" + coad);
                return;
            }
            InputStream is = conn.getInputStream();
            String info = IS2IN(is);

            Message message = new Message();
            message.what=1;
            message.obj = info;
            handler.sendMessage(message);

            JSONObject js = new JSONObject();
            int jsoncoad = js.getInt("coad");
            if (jsoncoad == 0) {
//                ToastUtil.showToast(this, "请求失败");
                String msg = js.getString("msg");
                Message message1 = handler.obtainMessage();
                message1.what=2;
                message1.obj=msg;
                handler.sendMessage(message1);


            } else {
                JSONObject jo = new JSONObject("data");
                String token = jo.getString("token");
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("token", token);
                edit.commit();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String IS2IN(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;

        try {
            while ((len = is.read()) != -1) {
                baos.write(len);

            }
            is.close();
            baos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }
}
