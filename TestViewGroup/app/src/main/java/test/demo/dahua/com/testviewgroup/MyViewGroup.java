package test.demo.dahua.com.testviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dragon on 2017/9/27.
 */

public class MyViewGroup extends ViewGroup {

    private int totalWidth;
    private int totalHeight;

    public MyViewGroup(Context context) {
        this(context,null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

       super.onMeasure(widthMeasureSpec, heightMeasureSpec);

       totalWidth = 0;
        totalHeight = 0;
       measureChildren(widthMeasureSpec, heightMeasureSpec);
       for(int i=0;i<getChildCount();i++){
            View childAt = getChildAt(i);




          // childAt.measure(0,0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            totalWidth += measuredWidth;
            totalHeight += measuredHeight;

        }


        setMeasuredDimension(totalWidth, totalHeight);


    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;

        for (int i=0;i<getChildCount();i++) {
            View childView = getChildAt(i);

            childView.layout(left, top, left + childView.getMeasuredWidth(), top + childView.getMeasuredHeight());
            left += childView.getWidth();
            top += childView.getHeight();
        }


    }
}
