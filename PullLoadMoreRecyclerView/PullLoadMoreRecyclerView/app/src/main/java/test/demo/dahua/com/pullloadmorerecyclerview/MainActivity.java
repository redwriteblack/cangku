package test.demo.dahua.com.pullloadmorerecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean isSlidingToLast = false;
    private PullLoadMoreRecyclerView plm;
    private ArrayList<String> strings;
    private MainRVAdapter adapter;
    private boolean isFirstBottm = true;
    private boolean loading = true;
    private int visibleItemCount;
    private int totalItemCount;
    private int firstVisibleItem;
    private double previousTotal;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    strings.add(0, "我是刷新");
                    adapter.notifyDataSetChanged();
                    plm.setPullRefreshComplete();


                    break;


                case 2:

                    strings.add("加载更多");

                    adapter.notifyDataSetChanged();
                    isFirstBottm = true;

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strings = new ArrayList<>();
        plm = (PullLoadMoreRecyclerView) findViewById(R.id.plm);

        final LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        for (int i = 0; i < 60; i++) {
            strings.add(i + "");
        }

        plm.setLayoutManager(lm);
        adapter = new MainRVAdapter(this, strings);
        plm.setAdapter(adapter);


        //记载更多
        plm.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = lm.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = lm.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast&&isFirstBottm) {
                        //加载更多功能的代码


                        isFirstBottm = false;
                        Message message = handler.obtainMessage();
                        message.what = 2;
                        handler.sendMessageDelayed(message, 3000);

                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dx > 0 || dy > 0) {
                    //大于0表示，正在向右滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0 表示停止或向左滚动
                    isSlidingToLast = true;
                }

            }
        });


        //下拉刷新

                plm.setOnPullRefreshListenner(new PullLoadMoreRecyclerView.onPullRefreshListenner() {
                    @Override
                    public void pullRefresh() {

                        Message msg = handler.obtainMessage();
                        msg.what = 1;
                        handler.sendMessageDelayed(msg, 3000);


                        // plm.setPullRefreshComplete();

                    }
                });


            }


        }
