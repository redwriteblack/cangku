package test.demo.dahua.com.pullloadmorerecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;



/**
 * Created by dragon on 2017/9/29.
 */

public class PullLoadMoreRecyclerView extends RecyclerView {

    private View headView;
    private TextView tv_stat;
    private int scrollState;
    private LinearLayoutManager lm;
    private int downY;
    private int moveY;
    private int upY;
    private int headHeight;
    private RefreshStat refreshStat;
    private RefreshStat currentStat;
    private String TAG="AAA";
    private boolean isFirstBottm = true;

    public PullLoadMoreRecyclerView(Context context) {
        super(context);
    }

    public PullLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (headView == null) {


            refreshStat = RefreshStat.SUCCESS;

            headView = getChildAt(0);
            tv_stat = (TextView) headView.findViewById(R.id.tv_stat);
            headHeight = headView.getMeasuredHeight();
            headView.setPadding(0,-headHeight,0,0);

            lm = (LinearLayoutManager) getLayoutManager();
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {




        // if(lm.findFirstVisibleItemPosition()==1){

            switch (e.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    downY = (int) e.getY();



                case MotionEvent.ACTION_MOVE:

                    moveY = (int) e.getY();

                    if(moveY-downY<headHeight&&refreshStat!=RefreshStat.REFRESHING){



                      //  setStateText(refreshStat);
                        currentStat = RefreshStat.PULL_TO_REFRESH;

                    } else if (moveY - downY >= headHeight&&refreshStat!=RefreshStat.REFRESHING) {
                        currentStat = RefreshStat.RELEASE_TO_REFRESH;
                    }
                    if(-headHeight+(moveY-downY)<0){
                        headView.setPadding(0,-headHeight+(moveY-downY),0,0);
                    }else{
                        headView.setPadding(0,-headHeight+(moveY-downY)/3,0,0);
                    }



                    break;
                case MotionEvent.ACTION_UP:


                    upY = (int) e.getY();
                    if(upY-downY<=headHeight){
                        headView.setPadding(0, -headHeight, 0, 0);
                        return super.onTouchEvent(e);
                    }

                    if( lm.findFirstVisibleItemPosition()==0){


                       /* if (refreshStat == RefreshStat.REFRESHING) {
                            return super.onTouchEvent(e);
                        }*/
                        currentStat = RefreshStat.REFRESHING;
                        headView.setPadding(0,0,0,0);
                        if (refreshStat != RefreshStat.REFRESHING) {
                            if(onPullRefreshListenner!=null){

                                onPullRefreshListenner.pullRefresh();
                                //setPullRefreshComplete();

                                Log.e(TAG, "onTouchEvent: "+"我要开始刷新了" );
                            }

                        }

                    }else{
                        if(refreshStat==RefreshStat.REFRESHING){
                            headView.setPadding(0,0,0,0);

                        }else{
                            headView.setPadding(0,-headHeight,0,0);
                        }

                    }



                    break;
            }

        if (refreshStat != currentStat) {
            setStateText(currentStat);
        }


        refreshStat = currentStat;



            //return true;

        //}



        return super.onTouchEvent(e);
    }

    public void setPullRefreshComplete(){
        currentStat = RefreshStat.SUCCESS;
        headView.setPadding(0,-headHeight,0,0);
    }

    private void setStateText(RefreshStat refreshStat) {
        switch (refreshStat) {
            case PULL_TO_REFRESH:



                tv_stat.setText("下拉刷新");

                break;
            case RELEASE_TO_REFRESH:

                tv_stat.setText("松手以刷新");

                break;

            case REFRESHING:
                tv_stat.setText("正在刷新...");
                break;
            case SUCCESS:

                tv_stat.setText("刷新完成");

                break;
        }

    }




    enum RefreshStat{
        PULL_TO_REFRESH,RELEASE_TO_REFRESH,REFRESHING,SUCCESS
    }

    onPullRefreshListenner onPullRefreshListenner;

    public void setOnPullRefreshListenner(PullLoadMoreRecyclerView.onPullRefreshListenner onPullRefreshListenner) {
        this.onPullRefreshListenner = onPullRefreshListenner;
    }

    public interface onPullRefreshListenner{
        void pullRefresh();
    }


    OnLoadMoreListenner onLoadMoreListenner;

    public void setOnLoadMoreListenner(OnLoadMoreListenner onLoadMoreListenner) {
        this.onLoadMoreListenner = onLoadMoreListenner;
    }


    public interface OnLoadMoreListenner{
        void loadMore();
    }

}
