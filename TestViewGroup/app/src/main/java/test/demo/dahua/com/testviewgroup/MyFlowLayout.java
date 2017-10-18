package test.demo.dahua.com.testviewgroup;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dragon on 2017/9/27.
 */

public class MyFlowLayout extends ViewGroup {
    private int mar;
    private int ver;

    public MyFlowLayout(Context context) {
        this(context, null);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        int height = 0;

        int count = 1;

        int currentTotalWith = mar;

        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);


        if (mode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);


        } else {
            width = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();


        }


        if (mode1 == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        } else {

            if (getChildCount() == 0) {
                count = 0;
            } else {
                int everyHeight = getChildAt(0).getMeasuredHeight()+ver;

                for (int i = 0; i < getChildCount(); i++) {
                    View view = getChildAt(i);


                    currentTotalWith += view.getMeasuredWidth()+mar;
                    if (currentTotalWith > width) {
                        count++;
                        currentTotalWith = view.getMeasuredWidth();

                    } else {

                        // currentTotalWith += view.getMeasuredWidth();
                    }

                }

                height = everyHeight * count;
            }


        }

        setMeasuredDimension(width, height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int currentLeft =0;
        int currentTop = 0;
        int count = 0;
        int everyHeight = 0;
        if (getChildCount() >= 1) {
            everyHeight = getChildAt(0).getMeasuredHeight()+ver;
        }


        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);

            currentLeft += view.getMeasuredWidth()+mar;

            if (currentLeft > getMeasuredWidth()) {
                count++;
                currentTop = count * everyHeight;
                currentLeft = view.getMeasuredWidth()+mar;
            } else {


            }

                view.layout(currentLeft - view.getMeasuredWidth(), currentTop, currentLeft, currentTop + view.getMeasuredHeight());





        }

    }

    public void setHor(int mar){
        this.mar = mar;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }




    public void setDataSource(ArrayList<String> strs) {
        for (int i = 0; i < strs.size(); i++) {

            Random random = new Random();
            int r = random.nextInt(256);

            int g = random.nextInt(256);

            int b = random.nextInt(256);

            RadioTextView textView = new RadioTextView(getContext());
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(params);
            textView.setmTitleText(strs.get(i));
            textView.setmTitleTextColor(Color.parseColor("#ffffff"));
            textView.setPadding(20,5,20,5);
            textView.setBackgroundColor(Color.argb(255,r,g,b));
            //textView.setGravity(Gravity.CENTER);

            addView(textView);

        }
    }

}
