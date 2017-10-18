package test.demo.dahua.com.testlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dragon on 2017/9/8.
 */

public class MyBaseAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> list;

    public MyBaseAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_01);
        GlideApp
			.with(context)
			.load(list.get(position))
			.placeholder(R.mipmap.ic_launcher)
			.into(iv);
        return view;
    }
}