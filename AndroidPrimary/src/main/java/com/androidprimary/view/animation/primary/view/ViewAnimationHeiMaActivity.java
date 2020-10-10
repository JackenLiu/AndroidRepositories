package com.androidprimary.view.animation.primary.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidprimary.R;

/**
 * View 动画
 * View 的显示位置本身没有变化，显示的只是动画
 */
public class ViewAnimationHeiMaActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_hei_ma);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewAnimationHeiMaActivity.this,
                        "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void alpha(View view) {
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(2000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(0);
        // 默认是 false 也就是执行完后恢复到初始状态
        animation.setFillAfter(false);
        iv.startAnimation(animation);
    }

    public void set(View view) {
        AnimationSet animationSet = new AnimationSet(false);

        AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
        aa.setDuration(2000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        aa.setRepeatMode(Animation.REVERSE);
        aa.setRepeatCount(0);
        // 默认是 false 也就是执行完后恢复到初始状态
        aa.setFillAfter(false);

        RotateAnimation ra = new RotateAnimation(0, 360);
        ra.setDuration(1000);
        ra.setRepeatMode(Animation.REVERSE);
        ra.setRepeatCount(1);
        ra.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(1, 2, 1, 2);
        sa.setDuration(1000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        sa.setRepeatMode(Animation.REVERSE);
        sa.setRepeatCount(3);
        // 默认是 false 也就是执行完后恢复到初始状态
        sa.setFillAfter(false);

        TranslateAnimation ta = new TranslateAnimation(
                10, 100, 10, 100);
        ta.setDuration(1000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        ta.setRepeatMode(Animation.REVERSE);
        ta.setInterpolator(new BounceInterpolator());
        ta.setRepeatCount(3);
        // 默认是 false 也就是执行完后恢复到初始状态
        ta.setFillAfter(false);

        animationSet.addAnimation(aa);
        animationSet.addAnimation(ra);
        animationSet.addAnimation(sa);
        animationSet.addAnimation(ta);

        iv.startAnimation(animationSet);
    }

    public void translate(View view) {
//        TranslateAnimation animation = new TranslateAnimation(
//                10, 100, 10, 100);
        int fromXType = Animation.RELATIVE_TO_PARENT;
        int toXType = Animation.RELATIVE_TO_PARENT;
        int fromYType = Animation.RELATIVE_TO_PARENT;
        int toYType = Animation.RELATIVE_TO_PARENT;
        float fromXValue = -0.5f;
        float toXValue = 0.5f;
        float fromYValue = -0.5f;
        float toYValue = 0.5f;

        TranslateAnimation animation = new TranslateAnimation(
                fromXType, fromXValue, toXType, toXValue
                , fromYType, fromYValue, toYType, toYValue);
        animation.setDuration(1000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        animation.setRepeatMode(Animation.REVERSE);
        animation.setInterpolator(new BounceInterpolator());
        animation.setRepeatCount(3);
        // 默认是 false 也就是执行完后恢复到初始状态
        animation.setFillAfter(false);
        iv.startAnimation(animation);
    }

    public void scale(View view) {
//        ScaleAnimation animation = new ScaleAnimation(1, 2, 1, 2);

        int pivotXType = Animation.RELATIVE_TO_SELF;
        float pivotXValue = 0.5f;
        int pivotYType = Animation.RELATIVE_TO_SELF;
        float pivotYValue = 0.5f;
        ScaleAnimation animation = new ScaleAnimation(1, 1.5f, 1, 1.5f
                , pivotXType, pivotXValue, pivotYType, pivotYValue);
        animation.setDuration(1000);
        // 设置重复模式, Animation.REVERSE 表示反向执行
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(3);
        // 默认是 false 也就是执行完后恢复到初始状态
        animation.setFillAfter(false);
        iv.startAnimation(animation);
    }

    public void rotate(View view) {
//        RotateAnimation animation = new RotateAnimation(0, 360);
        // 旋转中心点 x 坐标的类型
        int pivotXType = Animation.RELATIVE_TO_PARENT;
        // 旋转中心点 x 坐标的值，如果是相对自己或者相对父容器，1.0 代表 100%
        float pivotXValue = 0.5f;
        // 旋转中心点 y 坐标的类型
        int pivotYType = Animation.ABSOLUTE;
        // 旋转中心点 y 坐标的值，如果是相对自己或者相对父容器，1.0 代表 100%
        float pivotYValue = 0.5f;

        RotateAnimation animation = new RotateAnimation(0, 360,
                pivotXType, pivotXValue, pivotYType, pivotYValue);
        animation.setDuration(1000);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(1);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
    }
}