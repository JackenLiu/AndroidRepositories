package com.uihigherdemo.event.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.uihigherdemo.event.SearchViewController;


public class SlideAreaView extends View {

    public SlideAreaView(Context context) {
        super(context);
    }

    public SlideAreaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideAreaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 不消费，直接把事件给了父控件，这里调用此 api，则事件直接发给 AdMainViewPager 了，
        // 所以取消事件在 AdMainViewPager 里面取消
        SearchViewController.stop();
        return false;
    }
}
