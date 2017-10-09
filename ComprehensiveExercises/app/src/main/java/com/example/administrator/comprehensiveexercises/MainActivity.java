package com.example.administrator.comprehensiveexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.administrator.comprehensiveexercises.adapter.MainRecyclerViewAdapter;
import com.example.administrator.comprehensiveexercises.jsonbean.MainBean;
import com.example.administrator.comprehensiveexercises.toast.ToastUtil;
import com.example.administrator.comprehensiveexercises.urlutils.UrlUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private ArrayList<MainBean.DataBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = (RecyclerView) findViewById(R.id.rv_main);

      /*  Integer[] imgs = {R.drawable.dafenlie_yaoping, R.drawable.dafenlie_yiliao, R.drawable.dafenlie_baojianp,
                R.drawable.dafenlie_shipin, R.drawable.dafenlie_qita};*/

        list = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv_main.setLayoutManager(gridLayoutManager);
        final MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(this, list);
        rv_main.setAdapter(mainRecyclerViewAdapter);

        OkHttpUtils
                .get()
                .url(UrlUtils.MAIN)
                .addParams("parent_id","0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.toastShow(MainActivity.this,"请求失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.toastShow(MainActivity.this,"请求成功");
                        if (TextUtils.isEmpty(response)) {
                            ToastUtil.toastShow(MainActivity.this,"为空");
                            return;
                        }
                        Gson gson = new Gson();
                        MainBean mainBean = gson.fromJson(response, MainBean.class);
                        if (mainBean.getCode() != 200) {
                            ToastUtil.toastShow(MainActivity.this, "请求失败");
                        } else {
                            list.addAll(mainBean.getData());
                            mainRecyclerViewAdapter.notifyDataSetChanged();
                        }


                    }
                });








    }
}
