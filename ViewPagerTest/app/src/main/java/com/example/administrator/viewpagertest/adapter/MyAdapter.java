package com.example.administrator.viewpagertest.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.viewpagertest.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends PagerAdapter {
    private Context context;
    private List<String> imgs;

    public MyAdapter(Context context, List<String> imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.size()*100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_first, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.im_first);




        Picasso.with(context).load(imgs.get(position%imgs.size())).into(imageView);
        container.addView(view);
        return view;
    }
}
