package com.uihigherdemo.event;


import android.util.Log;

import com.uihigherdemo.event.view.FirstRecyclerView;
import com.uihigherdemo.event.view.StoppableScrollView;

/**
 * 指定 view 的事件控制器
 */
public class SearchViewController {

    private static StoppableScrollView scrollView;
    private static FirstRecyclerView recyclerView;

    private static SearchViewController controller;

    public static SearchViewController getInstance(StoppableScrollView scrollView,
                                                   FirstRecyclerView recyclerView) {
        synchronized (SearchViewController.class) {
            if (controller == null) {
                controller = new SearchViewController();
                SearchViewController.scrollView = scrollView;
                SearchViewController.recyclerView = recyclerView;
            }
        }
        return controller;
    }

    public static void stop() {
        Log.d(", ", "关闭了滑动——————————————: ");

        try {
            scrollView.disableScroll(true);
            recyclerView.disableScroll(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void slide() {
        Log.d(", ", "开启了滑动——————————————: " );

        try {
            scrollView.disableScroll(false);
            recyclerView.disableScroll(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
