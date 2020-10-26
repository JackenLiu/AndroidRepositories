package com.androidprimary.ui.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.androidprimary.R;
import com.androidprimary.ui.listview.SkewAnimation.SkewAnimation;

public class ListViewComplexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_complex);

        ListView listView = findViewById(R.id.ll);
        listView.setAdapter(new MyAdapter());

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int previousFirstVisibleItem = 0;
            private long previousEventTime = 0;
            private double speed = 0;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d("------", totalItemCount + "");
                if (previousFirstVisibleItem != firstVisibleItem) {
                    long currTime = System.currentTimeMillis();
                    long timeToScrollOneElement = currTime - previousEventTime;
                    speed = ((double) 1 / timeToScrollOneElement) * 1000;
                    previousFirstVisibleItem = firstVisibleItem;
                    previousEventTime = currTime;
                    Log.d("DBG", "Speed: " + speed + " elements/second");
                }
            }
        });
    }

    private int lastIndex;

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            第一个参数 上下文
            第二个参数 布局 id
            第三个参数 ViewGroup (比如 LinerLayout)，如果 ViewGroup 传入一个具体对象，那么这个方法创建出来的
            View 对象就会作为这个 ViewGroup 的一个 childView ，现在只是把 xml 文件转换成 View 对象，不需要放到
            ViewGroup 中，所以传 null
             */
            View view;
            if (convertView == null) {
                view = View.inflate(ListViewComplexActivity.this, R.layout.item_coupon_page_coupon_list, null);
            } else {
                view = convertView;
                AnimationSet animationSet = new AnimationSet(true);

                TranslateAnimation translateAnimation = new TranslateAnimation(200, 0, 0, 0);
                translateAnimation.setDuration(1500);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(1200);
                SkewAnimation ska = new SkewAnimation();
                if (position > lastIndex) {
                    ska.setSkewAngle(3, 0, -3, 0);

                    animationSet.addAnimation(translateAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.addAnimation(ska);
                } else {
                    ska.setSkewAngle(0, 0, 3, 0);
                    animationSet.addAnimation(ska);

                }
                ska.setDuration(1200);
                ska.setInterpolator(new AccelerateDecelerateInterpolator());

                view.startAnimation(animationSet);
            }
            lastIndex = position;

            return view;
        }
    }

}