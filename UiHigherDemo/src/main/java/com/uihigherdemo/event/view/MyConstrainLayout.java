package com.uihigherdemo.event.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.uihigherdemo.event.SearchViewController;

public class MyConstrainLayout extends ConstraintLayout {
    public MyConstrainLayout(Context context) {
        super(context);
    }

    public MyConstrainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConstrainLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("MyConstrainLayout, ", "dispatchTouchEvent: " + ev.getAction());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d("MyConstrainLayout, ", "onInterceptTouchEvent: " + e.getAction());
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.d("MyConstrainLayout, ", "onTouchEvent: " + e.getAction());

        return super.onTouchEvent(e);
    }
}
