package com.bawei.dongyong20191127.wight;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.dongyong20191127.app.AppUrl;

/**
 * @auther:董青勇
 * @Date: 2019/11/27
 * @Time: 9:51
 * @Description:
 */
public class MyView  extends ViewGroup {
    public   Context mcontext;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
       mcontext=context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取总数量
        int childCount = getChildCount();
        int space=10;
        int left=0;
        int right=0;
        int top=0;
        int bottom=0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.measure(0,0);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            left=right+space;
            right=left+measuredWidth;
            int width = getWidth();
            if(right>width){
                left=space;
                top=bottom+space;
            }
            right=left+measuredWidth;
            bottom=measuredHeight+top;
         childAt.layout(left,top,right,bottom);
        }

    }

    public  void addTag(String  content){
        TextView textView = new TextView(AppUrl.context);
        textView.setTextColor(Color.YELLOW);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
         textView.setText(content);
          addView(textView);
    }
}
