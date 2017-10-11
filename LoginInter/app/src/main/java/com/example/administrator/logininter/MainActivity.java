package com.example.administrator.logininter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends Activity {
    private EditText et_uname;
    private EditText et_pwd;
    private EditText et_yanzheng;
    private Button btn_login;
    private TextView tv_content;
    private SharedPreferences sp;
    private ImageView iv_01;

    public final String TAG = "MainActivity";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String info = (String) msg.obj;
                    tv_content.setText(info);

                    break;

                case 2:
                    String info2 = (String) msg.obj;
                    ToatUtil.showToast(MainActivity.this, info2);

                    break;


                case 3:
                    Bitmap b = (Bitmap) msg.obj;
                    iv_01.setImageBitmap(b);
                    break;

                case 4:
                    String info3 = (String) msg.obj;
                    tv_content.setText(info3);

                    break;


            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("inter.xml", 0);



        et_uname = (EditText) findViewById(R.id.et_uname);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_yanzheng = (EditText) findViewById(R.id.et_yanzheng);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_content = (TextView) findViewById(R.id.tv_content);
        iv_01 = (ImageView) findViewById(R.id.iv_01);


        //http://192.168.1.254:8061/index.php?m=member&c=public&a=app_register

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url("http://pic14.photophoto.cn/20100325/0010023565924970_b.jpg")
                .get().build();



        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               // byte[] bytes = response.body().bytes();
                ResponseBody body = response.body();

                InputStream inputStream = body.byteStream();
                // Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0,bytes.length);
                Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
                Message msg = handler.obtainMessage();
                msg.what=3;
                msg.obj = bitmap1;
                handler.sendMessage(msg);





            }
        });



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*

                new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        registe();
                    }
                }.start();
*/

               // okHttpGet();

                okHttpPost();


            }
        });


    }

    private void okHttpPost() {
        String uname = et_uname.getText().toString();
        String pwd = et_pwd.getText().toString();
        String yanZheng = et_yanzheng.getText().toString();
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).build();


        //http://192.168.1.250:8061/index.php?m=member&c=public&a=app_register
        String url = "http://192.168.1.250:8061/index.php";
        RequestBody body = new FormBody.Builder()
                .add("m", "member")
                .add("c", "public")
                .add("a", "app_register")
                .add("mobile", uname)
                .add("password", pwd)
                .add("captcha", yanZheng)
                .build();

        


        Request request = new Request.Builder().url(url).post(body).build();
      //  client.
Call call= client.newCall(request);



      call .enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body1 = response.body();
                String info = body1.string();
                Gson gson=new Gson();
                LoginBean loginBean = gson.fromJson(info, LoginBean.class);
                if(loginBean.getCode()==200){
                    LoginBean.DataBean data = loginBean.getData();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("token", data.getToken());
                    editor.commit();
                }
                String msg = loginBean.getMsg();
                Message message = handler.obtainMessage();
                message.what=4;
                message.obj = msg;
                handler.sendMessage(message);

              //  Log.e(TAG, body1.string());
            }
        });


    }

    private void okHttpGet() {
        String uname = et_uname.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        String yanZheng = et_yanzheng.getText().toString().trim();
        String path = "http://192.168.1.250:8061/index.php?m=member&c=public&a=app_register&" +
                "mobile=" + uname + "&password=" + pwd + "&captcha=" + yanZheng;


        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                ResponseBody body = response.body();
                final String s = body.string();


                Message message = handler.obtainMessage();
                message.what = 1;
                message.obj = s;
                handler.sendMessage(message);
              /*  runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_content.setText(s);
                    }
                });*/

              /*  handler.post(new Runnable() {
                    @Override
                    public void run() {

                            tv_content.setText(s);
                    }
                });*/

//                        tv_content.setText(s);

            }
        });
    }

    private void registe() {
        try {
            String uname = et_uname.getText().toString().trim();
            String pwd = et_pwd.getText().toString().trim();
            String yanZheng = et_yanzheng.getText().toString().trim();
            String path = "http://192.168.1.250:8061/index.php?m=member&c=public&a=app_register&" +
                    "mobile=" + uname + "&password=" + pwd + "&captcha=" + yanZheng;


            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(10000);
            int code = conn.getResponseCode();

            if (code != 200) {
                // ToatUtil.showToast(this, "请求失败" + code);
                System.out.println("code" + code);

                return;
            }

            //冗余
            InputStream is = conn.getInputStream();

            String info = IO2Str(is);
            Message message = new Message();
            message.what = 1;
            message.obj = info;
            handler.sendMessage(message);
            // tv_content.setText(info);
            JSONObject jo = new JSONObject(info);
            int joCode = jo.getInt("code");
            if (joCode == 0) {
                String msg = jo.getString("msg");

                Message message1 = handler.obtainMessage();
                message1.what = 2;
                message1.obj = msg;
                handler.sendMessage(message1);
                // ToatUtil.showToast(this, msg);
                System.out.println(msg);
            } else {
                String msg = jo.getString("msg");
                //ToatUtil.showToast(this, msg);
                System.out.println(msg);
                JSONObject innerJo = jo.getJSONObject("data");
                String token = innerJo.getString("token");
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("token", token);
                editor.commit();


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String IO2Str(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] arr = new byte[100];

        try {
            while ((len = is.read(arr)) != -1) {
                baos.write(arr, 0, len);
            }

            is.close();
            baos.close();
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";

    }


}
