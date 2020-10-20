package com.uihigherdemo.event.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class StoppableScrollView extends ScrollView {


    public StoppableScrollView(Context context) {
        super(context);
    }

    public StoppableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StoppableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Boolean disable = false;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !disable && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return !disable && super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return !disable && super.dispatchTouchEvent(ev);
    }

    public void disableScroll(Boolean disable) {
        this.disable = disable;
    }

}
