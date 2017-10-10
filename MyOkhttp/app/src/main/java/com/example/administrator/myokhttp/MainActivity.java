package com.example.administrator.myokhttp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private EditText et_yanzheng;
    private Button but_login;
    private TextView tv_count;
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
                case  2:
                    String info1 = (String) msg.obj;
                    tv_count.setText(info1);

                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_yanzheng = (EditText) findViewById(R.id.et_yanzheng);
        but_login = (Button) findViewById(R.id.but_login);
        tv_count = (TextView) findViewById(R.id.tv_count);


        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OkHttp中的get请求
//                getOkHttp();
                //OkHttp中的post请求
                postOkHttp();


            }
        });

    }

    private void postOkHttp() {
        String name = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String yanzheng = et_yanzheng.getText().toString().trim();


        final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS).build();
        String url = "http://192.168.1.250:8061/index.php";
        RequestBody body = new FormBody.Builder()
                .add("m", "member")
                .add("c", "public")
                .add("a", "app_register")
               .add("password", "password")
                .add("captcha", "yanzheng")
                .build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body1 = response.body();
                String info = body1.string();
                Gson gson = new Gson();
                GsonText gsonText = gson.fromJson(info, GsonText.class);
                if (gsonText.getCode()==200) {
                    GsonText.DataBean data = gsonText.getData();
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("token", data.getToken());
                    edit.commit();


                }

                Message message = new Message();
                message.what = 2;
                message.obj = info;
                handler.sendMessage(message);



            }
        });
    }

    private void getOkHttp() {
        String name = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String yanzheng = et_yanzheng.getText().toString().trim();

        String path = "http://192.168.1.250:8061/index.php?m=member&c=public&a=app_register&" +

                "moblie=" + name + "&password=" + password + "&capthca=" + yanzheng;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                String s = body.string();

                Message message = new Message();
                message.what = 1;
                message.obj = s;
                handler.sendMessage(message);


            }
        });
    }
}
