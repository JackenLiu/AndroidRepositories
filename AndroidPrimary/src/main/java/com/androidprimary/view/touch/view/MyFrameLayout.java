package com.androidprimary.view.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by zhy on 15/8/1.
 */
public class MyFrameLayout extends FrameLayout {
    private static final String TAG = "MyFrameLayout";

    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result;

        final int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent - ACTION_UP");
                break;
        }
        result = super.dispatchTouchEvent(ev);
        return result;
    }

    private int mLastY;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result;

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_DOWN");
                mLastY = ev.getAction();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_MOVE");

//                if(ev.getY() - mLastY >200)
//                {
//                    Log.e(TAG, "onInterceptTouchEvent - ACTION_MOVE - return true ");
//                    return true ;
//                }

                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_UP");
                break;
        }

        result = super.onInterceptTouchEvent(ev);
//        Log.e(TAG, "onInterceptTouchEvent - result: " + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result;

        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent - ACTION_UP");//
                break;
        }

        result = super.onTouchEvent(event);
        return result;
    }
}
