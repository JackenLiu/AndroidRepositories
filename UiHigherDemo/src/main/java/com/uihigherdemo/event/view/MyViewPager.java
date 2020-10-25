package com.uihigherdemo.event.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.uihigherdemo.event.SearchViewController;

public class MyViewPager extends ViewPager {

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("MyViewPager, ", "dispatchTouchEvent: " + ev.getAction());
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            SearchViewController.slide();
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d("MyViewPager, ", "onInterceptTouchEvent: " + e.getAction());
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.d("MyViewPager, ", "onTouchEvent: " + e.getAction());
        return super.onTouchEvent(e);
    }
}
