package com.uihigherdemo.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import java.util.ArrayList;
import java.util.List;

public class MyNestedScrollView extends NestedScrollView {
    private List<View> itemViews;
    private TestSkewActivity testSkewActivity;

    public void setTestSkewActivity(TestSkewActivity testSkewActivity) {
        this.testSkewActivity = testSkewActivity;
    }

    public void setItemViews(List<View> itemViews) {
        this.itemViews = itemViews;
    }

    public MyNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float initY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float moveY = ev.getY();
                Log.d("--------", ((moveY - initY)) + "");
                testSkewActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (View view : itemViews) {
                            SkewTextView skewTextView = (SkewTextView) view;
//                            skewTextView.upDateSkew((moveY - initY) / 100);
                        }
                    }
                });

                initY = moveY;
                break;
            default:
        }
        return super.onTouchEvent(ev);
    }
}
