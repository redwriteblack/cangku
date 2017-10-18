package test.demo.dahua.com.pullloadmorerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dragon on 2017/9/29.
 */

public class MainRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<String> strings;

    public MainRVAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        switch (viewType) {
            case 0:

                View headView = LayoutInflater.from(context).inflate(R.layout.item_head, parent, false);
                return new HeadHolder(headView);


            case 1:

                View text = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
                return new TextHolder(text);


            case 2:

                View footer = LayoutInflater.from(context).inflate(R.layout.item_footer, parent, false);
                return new FooterHolder(footer);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position==1){
            TextHolder textHolder = (TextHolder) holder;
            textHolder.tv.setText(strings.get(0));

        }else if(position>1&&position<=getItemCount()-1-1){
            TextHolder textHolder = (TextHolder) holder;
            textHolder.tv.setText(strings.get(position-1));
        }

    }

    @Override
    public int getItemCount() {
        return strings.size()+1+1;
    }

    @Override
    public int getItemViewType(int position) {
       if(position==0){
           return 0;
       }else if(position==getItemCount()-1){
           return 2;
       }else{
           return 1;
       }
    }

    class TextHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public TextHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public FooterHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);

        }
    }


    class HeadHolder extends RecyclerView.ViewHolder{
        TextView tv_stat;


        public HeadHolder(View itemView) {
            super(itemView);

            tv_stat = (TextView) itemView.findViewById(R.id.tv_stat);

        }
    }

}
