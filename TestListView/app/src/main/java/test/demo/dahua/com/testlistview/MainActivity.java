package test.demo.dahua.com.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_01;
    private ArrayList<String> list;
    private MyBaseAdapter myBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_01 = (ListView) findViewById(R.id.lv_01);
        list = new ArrayList<>();
       /* for(int i=0;i<20;i++){
            list.add("测试数据" + i);
        }
*/
        list.add("http://s16.sinaimg.cn/mw690/001pPXi2gy6W1BdDgujcf&690");
        list.add("http://img1.gtimg.com/ent/pics/hv1/132/223/1559/101430972.jpg");
        list.add("http://img.tupianzj.com/uploads/allimg/160429/16-160429201630.jpg");
        list.add("http://s16.sinaimg.cn/mw690/001pPXi2gy6W1BdDgujcf&690");
        list.add("http://img1.gtimg.com/ent/pics/hv1/132/223/1559/101430972.jpg");
        list.add("http://img.tupianzj.com/uploads/allimg/160429/16-160429201630.jpg");
        list.add("http://s16.sinaimg.cn/mw690/001pPXi2gy6W1BdDgujcf&690");
        list.add("http://img1.gtimg.com/ent/pics/hv1/132/223/1559/101430972.jpg");
        list.add("http://img.tupianzj.com/uploads/allimg/160429/16-160429201630.jpg");
        myBaseAdapter = new MyBaseAdapter(this, list);




        lv_01.setAdapter(myBaseAdapter);




    }
}
