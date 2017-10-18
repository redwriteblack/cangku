package test.demo.dahua.com.pullloadmorerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PullLoadMoreRecyclerView plm;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strings = new ArrayList<>();
        plm = (PullLoadMoreRecyclerView) findViewById(R.id.plm);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        for (int i = 0; i < 60; i++) {
            strings.add(i + "");
        }

        plm.setLayoutManager(lm);
        plm.setAdapter(new MainRVAdapter(this, strings));



    }



}
