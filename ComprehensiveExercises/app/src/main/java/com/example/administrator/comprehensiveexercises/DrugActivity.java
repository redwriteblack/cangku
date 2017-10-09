package com.example.administrator.comprehensiveexercises;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.comprehensiveexercises.adapter.DrugLeftAdapter;
import com.example.administrator.comprehensiveexercises.adapter.DrugRightAdapter;
import com.example.administrator.comprehensiveexercises.jsonbean.DrugListBean;
import com.example.administrator.comprehensiveexercises.jsonbean.DrugRightBean;
import com.example.administrator.comprehensiveexercises.toast.ToastUtil;
import com.example.administrator.comprehensiveexercises.urlutils.UrlUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;



public class DrugActivity extends Activity {
    private RecyclerView rv_select;
    private RecyclerView rv_count;
    private List<DrugListBean.DataBean> list;
    private List<DrugRightBean.DataBean> data;
    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.axtivity_drug);

        Log.e("DrugActivity", "onCreate: -----------------1&&"+id);
        id = getIntent().getStringExtra("ID");
        Log.e("DrugActivity", "onCreate: -----------------2%%"+id);

        rv_select = (RecyclerView) findViewById(R.id.rv_select);
        rv_count = (RecyclerView) findViewById(R.id.rv_count);

        list = new ArrayList<>();
        //药品左边的RecycleView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_select.setLayoutManager(linearLayoutManager);
        final DrugLeftAdapter drugLeftAdapter = new DrugLeftAdapter(this,list);
        rv_select.setAdapter(drugLeftAdapter);

        OkHttpUtils.get()
                .url(UrlUtils.MAIN)
                .addParams("parent_id", id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("DrugActivity", "onCreate: -----------------失败");
                        ToastUtil.toastShow(DrugActivity.this,"请求失败");
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("DrugActivity", "onCreate: -----------------成功");
                        ToastUtil.toastShow(DrugActivity.this,"请求成功");
                        if (TextUtils.isEmpty(response)) {
                            ToastUtil.toastShow(DrugActivity.this,"为空");
                            return;
                        }
                        Gson gson = new Gson();
                        DrugListBean drugListBean = gson.fromJson(response, DrugListBean.class);
                        if (drugListBean.getCode() != 200) {
                            ToastUtil.toastShow(DrugActivity.this, "请求失败");
                        } else {
                            Log.e("DrugActivity", "onCreate: -----------------有数据");
                            list.clear();
                            list.addAll(drugListBean.getData());
                            drugLeftAdapter.notifyDataSetChanged();
                            Log.e("DrugActivity", "aaaaaa:++++++++++++++++ "+list.size());
                        }

                    }
                });


        data = new ArrayList<>();
        //药品右边的RecyclerView


       drugLeftAdapter.setOnDataCheckedListener(new DrugLeftAdapter.OnDataCheckedListener() {
           @Override
           public void dataCheck(int postion) {
               DrugListBean.DataBean dataBean = list.get(postion);
               String id = dataBean.getId();
               getRigtDataFromInter(id);


           }
       });



    }

    private void getRigtDataFromInter(String id) {
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rv_count.setLayoutManager(linearLayoutManager1);
        final DrugRightAdapter drugRightAdapter = new DrugRightAdapter(this,data);
        rv_count.setAdapter(drugRightAdapter);

        OkHttpUtils
                .get()
                .url(UrlUtils.RIGHTURL)
                .addParams("catid",id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.toastShow(DrugActivity.this,"请求失败");
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.toastShow(DrugActivity.this,"请求成功");
                        if (TextUtils.isEmpty(response)) {
                            ToastUtil.toastShow(DrugActivity.this,"为空");
                            return;
                        }

                        Gson gson = new Gson();
                        DrugRightBean drugRightBean = gson.fromJson(response, DrugRightBean.class);
                        if (drugRightBean.getCode() != 200) {
                            ToastUtil.toastShow(DrugActivity.this, "请求失败");
                        } else {
                            data.clear();
                            data.add(drugRightBean.getData());
                            drugRightAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}
