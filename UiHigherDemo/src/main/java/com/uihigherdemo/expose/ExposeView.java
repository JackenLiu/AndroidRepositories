package com.uihigherdemo.expose;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.uihigherdemo.R;

public class ExposeView extends View {
    //旋转圆的画笔
    private Paint mPaint;
    //扩散圆的画笔
    private Paint mHolePaint;
    //属性动画
    private ValueAnimator mValueAnimator;

    //背景色
    private int mBackgroundColor = Color.WHITE;
    private int[] mCircleColors;

    //表示旋转圆的中心坐标
    private float mCenterX;
    private float mCenterY;
    //表示斜对角线长度的一半
    private float mDistance;
    //6个小球的半径
    private float mCircleRadius = 18;
    //旋转大圆的半径
    private float mRotateRadius = 90;

    //当前大圆的旋转角度
    private float mCurrentRotateAngle = 0F;
    //当前大圆的半径
    private float mCurrentRotateRadius = mRotateRadius;
    //扩散圆的半径
    private float mCurrentHoleRadius = 0F;
    //表示旋转动画的时长
    private int mRotateDuration = 1200;

    public ExposeView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHolePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHolePaint.setColor(mBackgroundColor);
        mHolePaint.setStyle(Paint.Style.STROKE);
        mCircleColors = context.getResources().getIntArray(R.array.expose_circle_colors);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
        mDistance = (float) (Math.hypot(w, h) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mExposeState == null) {
            mExposeState = new RotateState();
        }
        mExposeState.drawState(canvas);
    }

    private ExposeState mExposeState;

    // 动画加载阶段
    private abstract class ExposeState {
        abstract void drawState(Canvas canvas);
    }

    // 1、小圆旋转 绘制 6 个小球，旋转
    private class RotateState extends ExposeState {

        public RotateState() {
            mValueAnimator = ValueAnimator.ofFloat(0, (float) (Math.PI * 2));
            mValueAnimator.setRepeatCount(2);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotateAngle = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mExposeState = new MerginState();
                }
            });
            mValueAnimator.start();
        }

        @Override
        void drawState(Canvas canvas) {
            drawBackground(canvas);
            drawCircles(canvas);
        }
    }

    private void drawCircles(Canvas canvas) {
        // 平均每个小圆的弧度
        float rotateAngle = (float) (Math.PI * 2 / mCircleColors.length);
        for (int i = 0; i < mCircleColors.length; i++) {
            float angel = i * rotateAngle + mCurrentRotateAngle;
            float cx = (float) (mCenterX + Math.cos(angel) * mCurrentRotateRadius);
            float cy = (float) (mCenterY + Math.sin(angel) * mCurrentRotateRadius);
            mPaint.setColor(mCircleColors[i]);
            canvas.drawCircle(cx, cy, mCircleRadius, mPaint);
        }
    }

    private void drawBackground(Canvas canvas) {
        if (mCurrentHoleRadius > 0) {
            float strokeWidth = mDistance - mCurrentHoleRadius;
            mHolePaint.setStrokeWidth(strokeWidth);
            //绘制空心圆
            canvas.drawCircle(mCenterX, mCenterY, mCurrentHoleRadius + strokeWidth / 2, mHolePaint);
        } else
            canvas.drawColor(mBackgroundColor);
    }

    //2、扩散、聚合 绘制6个小球 大圆半径变化
    private class MerginState extends ExposeState {

        public MerginState() {
            mValueAnimator = ValueAnimator.ofFloat(mCircleRadius, mRotateRadius);
//            mValueAnimator.setRepeatCount(2);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new OvershootInterpolator(10));
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotateRadius = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mExposeState = new Expose3State();
                }
            });
            mValueAnimator.reverse();
        }

        @Override
        void drawState(Canvas canvas) {
            drawBackground(canvas);
            drawCircles(canvas);
        }
    }

    //3、揭露效果 绘制空心圆
    private class Expose3State extends ExposeState {

        public Expose3State() {
            mValueAnimator = ValueAnimator.ofFloat(mCircleRadius, mDistance);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentHoleRadius = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.start();
        }

        @Override
        void drawState(Canvas canvas) {
            drawBackground(canvas);
        }
    }

    public void reStart() {
        if (mValueAnimator.isRunning()) {
            return;
        }

        mCurrentRotateAngle = 0F;
        mCurrentRotateRadius = mRotateRadius;
        mCurrentHoleRadius = 0F;
        mExposeState = new RotateState();
        invalidate();
    }
}
