package com.example.administrator.mypullloadingview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class PullLoadingView extends RecyclerView {

    private View headView;
    private int headHeight;
    private int downY;
    private int moveY;
    private int upY;
    private RefreshStat refreshStat;
    private RefreshStat currentStat;
    private LinearLayoutManager lm;

    public PullLoadingView(Context context) {
        this(context, null);
    }

    public PullLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullLoadingView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);


        if (headView == null) {
            refreshStat = RefreshStat.SUCCESS;
            headView = getChildAt(0);
            headHeight = headView.getMeasuredHeight();
            headView.setPadding(0, -headHeight, 0, 0);
            lm = (LinearLayoutManager) getLayoutManager();
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) e.getY();

                break;

            case MotionEvent.ACTION_MOVE:
                moveY = (int) e.getY();

                if (moveY - downY < 2 * headHeight) {
                    currentStat = RefreshStat.PULL_TO_REFRESH;
                } else if (moveY - downY > 2 * headHeight) {
                    currentStat = RefreshStat.RELEASE_TO_REFRESH;
                }

                headView.setPadding(0, -headHeight + (moveY - downY), 0, 0);

                break;
            case MotionEvent.ACTION_UP:
                upY = (int) e.getY();

                if (lm.findFirstVisibleItemPosition() == 0) {
                    currentStat = RefreshStat.REFRESHING;
                    if (refreshStat != RefreshStat.REFRESHING) {
                        if (onPullLoadingListenner != null) {
                            onPullLoadingListenner.pullLoading();
                        }

                    }
                    headView.setPadding(0, 0, 0, 0);
                } else {
                    headView.setPadding(0, 0, 0, 0);
                }


                break;
        }


        return super.onTouchEvent(e);
    }


    enum RefreshStat {
        PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, SUCCESS
    }

    OnPullLoadingListenner onPullLoadingListenner;

    public void setOnPullLoadingListenner(OnPullLoadingListenner onPullLoadingListenner) {
        this.onPullLoadingListenner = onPullLoadingListenner;
    }

    interface OnPullLoadingListenner {
        void pullLoading();
    }
}
