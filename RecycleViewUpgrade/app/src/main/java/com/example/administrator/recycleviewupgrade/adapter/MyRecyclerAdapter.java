package com.example.administrator.recycleviewupgrade.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.recycleviewupgrade.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/14.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> list;
    private final int FIRST_VIEW_TYPE = 0;
    private final int SECOND_VIEW_TYPE = 1;
    private final int THREE_VIEW_TYPE = 2;
    private final int FOUR_VIEW_TYPE = 3;


    public MyRecyclerAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST_VIEW_TYPE;
        } else if (position == 1) {
            return SECOND_VIEW_TYPE;
        } else if (position == 2) {
            return THREE_VIEW_TYPE;
        } else {
            return FOUR_VIEW_TYPE;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FIRST_VIEW_TYPE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_first, parent, false);
            return new FirstHolder(inflate);
        } else if (viewType == SECOND_VIEW_TYPE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_second, parent, false);
            return new SecondHolder(inflate);
        } else if (viewType == THREE_VIEW_TYPE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_three, parent, false);
            return new ThreeHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_four, parent, false);
            return new FourHolder(inflate);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            FirstHolder firstHolder = (FirstHolder) holder;
            firstHolder.name.setText(list.get(position));
        } else if (position == 1) {
            SecondHolder secondHolder = (SecondHolder) holder;

            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            secondHolder.rv_logo.setLayoutManager(linearLayoutManager1);
            secondHolder.rv_logo.setAdapter(new MyAdapterOne(context));
        } else if (position == 2) {
            ThreeHolder threeHolder = (ThreeHolder) holder;
            threeHolder.imageView.setImageResource(R.drawable.aa);


        } else {
            FourHolder fourHolder = (FourHolder) holder;
            fourHolder.imageView.setImageResource(R.drawable.bb);

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class FirstHolder extends RecyclerView.ViewHolder {
        TextView name;

        public FirstHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    class SecondHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_logo;

        public SecondHolder(View itemView) {
            super(itemView);
            rv_logo = (RecyclerView) itemView.findViewById(R.id.rv_logo);
        }
    }

    class ThreeHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ThreeHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.im_aa);
        }
    }

    class FourHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public FourHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.im_bb);
        }
    }


}
