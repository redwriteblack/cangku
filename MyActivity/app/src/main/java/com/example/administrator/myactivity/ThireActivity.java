package com.example.administrator.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ThireActivity extends Activity {
    private Button but_thired;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thire);

        but_thired = (Button) findViewById(R.id.but_thired);

        but_thired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThireActivity.this,SecondActivity.class));
            }
        });
    }
}
