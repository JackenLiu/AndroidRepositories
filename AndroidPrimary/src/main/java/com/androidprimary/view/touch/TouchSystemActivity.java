package com.androidprimary.view.touch;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.androidprimary.R;

public class TouchSystemActivity extends BaseContentActivity {

    private static final String TAG = "ToushSystemActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_system);
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
                Log.e(TAG, "onTouchEvent - ACTION_UP");
                break;
        }
        result = super.onTouchEvent(event);
        return result;
    }
}
