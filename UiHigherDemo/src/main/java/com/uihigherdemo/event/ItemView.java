package com.uihigherdemo.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.uihigherdemo.R;

public class ItemView extends ConstraintLayout {
    public ItemView(Context context) {
        super(context);
        initView(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_search_alphabet_grid, this, true);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("Item, ", "dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d("Item, ", "onInterceptTouchEvent: " + e.getAction());
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.d("Item, ", "onTouchEvent: " + e.getAction());
        return super.onTouchEvent(e);
    }
}
