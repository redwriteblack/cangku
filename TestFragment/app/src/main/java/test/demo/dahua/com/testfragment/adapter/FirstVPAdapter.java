package test.demo.dahua.com.testfragment.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import test.demo.dahua.com.testfragment.R;

/**
 * Created by dragon on 2017/9/19.
 */

public class FirstVPAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<String> srcs;

    public FirstVPAdapter(Context context, ArrayList<String> srcs) {
        this.context = context;
        this.srcs = srcs;
    }

    @Override
    public int getCount() {
        return srcs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vp_firt_act, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        Picasso.with(context).load(srcs.get(position)).into(imageView);

        container.addView(view);



        return view;
    }
}
