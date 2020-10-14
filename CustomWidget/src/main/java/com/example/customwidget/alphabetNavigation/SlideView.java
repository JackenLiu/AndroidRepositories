package com.example.customwidget.alphabetNavigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

public class SlideView extends View {

    private String[] mLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private Paint mPaint;
    private int mChoose;
    private float mDensity;
    /**
     * 字母点击拖动区域
     */
    private RectF mIsDownRect = new RectF();
    private boolean mIsBeingDragger, mStartEndAnim;
    /**
     * 触发移动事件的最小距离，自定义 View 处理 touch 事件的时候，有的时候需要判断用户是否真的存在 movie，
     * 系统提供了这样的方法。表示滑动的时候，手的移动要大于这个返回的距离值才开始移动控件。
     */
    private int mTouchSlop;

    /**
     * 控件减去边距宽度?
     */
    private float mHalfWidth;
    /**
     * 控件减去边距高度?
     */
    private float mHalfHeight;

    private float mLetterHeight;
    private float mAnimStep;

    private float mY;

    public SlideView(Context context) {
        this(context, null);
    }

    public SlideView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#666666"));
        mPaint.setTextAlign(Paint.Align.CENTER);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mDensity = getContext().getResources().getDisplayMetrics().density;
        // 整个控件设置上边距和下边距
        setPadding(0, dip2px(20), 0, dip2px(20));

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // 减去 init 方法里面设置的上边距和下边距
        mHalfHeight = h - getPaddingBottom() - getPaddingTop();
        // 减去字母列表右边的边距
        mHalfWidth = w - dip2px(16);
        // 字母的平均高度
        mLetterHeight = mHalfHeight / mLetters.length;
        // 字体的大小为字体高度的 0.7 倍
        int textSize = (int) (mLetterHeight * 0.7);
        mPaint.setTextSize(textSize);
        // 设置点击区域矩形范围
        mIsDownRect.set(w - dip2px(32), 0, w, h);

    }

    private int dip2px(int dipPx) {
        return (int) (dipPx * mDensity + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mLetters.length; i++) {
            // 单个字母左下角的 y 坐标
            float letterPosY = mLetterHeight * (i + 1) + getPaddingTop();
            // 字母放大倍数
            float diff;
            // 字母 x 放大倍数
            float diffY = 0;
            // 字母 y 放大倍数
            float diffX;

            // 当前字母被选中（顶点）
            if (mChoose == i && i != 0 && i != mLetters.length - 1) {
                // 选中的字母放大 2.2 倍
                diff = 2.2f;
                diffY = 0;
                diffX = 0;

            } else {
                /*
                maxPos, 点击的时候半弧度占控件高度的比例
                解释 mY - letterPosY：
                · 计算除了选中的字母外的其余字母的 y 坐标，到点击坐标的 y 坐标的距离
                · 计算原理：点击坐标的 y 坐标（mY），减去单个字母左下角的 y 坐标（letterPosY）
                · 这个值大于半个弧线宽度，则代表字母是静止状态，如果小于则代表在弧线状态

                解释 Math.abs(mY - letterPosY) / mHalfHeight：
                · 取值范围是 0 ~ 1 （mY 在最上面或者在最下面也就是控件高度）

                解释 7：
                适配的最佳比例得出的数值
                 */
                float maxPos = Math.abs(mY - letterPosY) / mHalfHeight * 7;

                // maxPos 要小于 1.2 才会取 2.2f - maxPos 的值
                diff = Math.max(1f, 2.2f - maxPos);

                // 如果到了点击字母的范围(弧线)
                if (mStartEndAnim && diff != 1f) {
                    // 放大倍数递减
//                    diff -= mAnimStep;
                    if (diff < 1) {
                        diff = 1;
                    }

                    // 没有手指拖动（静止）
                } else if (!mIsBeingDragger) {
                    diff = 1f;
                }

                diffY = maxPos * 50f * (letterPosY > mY ? -1 : 1);
                diffX = maxPos * 100;
            }

            canvas.save();
            // 写字母
            canvas.scale(diff, diff, mHalfWidth * 1.20f + diffX, letterPosY + diffY);

            if (mLetters[i].equals("G")) {
                Log.d("缩放标准点： ", (mHalfWidth * 1.20f + diffX) + "-----" + (letterPosY + diffY));
                canvas.drawCircle(
                        (mHalfWidth * 1.20f + diffX),
                        (letterPosY + diffY), 10, mPaint
                );
            }
            // 透明度
            if (diff == 1f) {
                mPaint.setAlpha(255);
                mPaint.setTypeface(Typeface.DEFAULT);
                mPaint.setColor(Color.parseColor("#666666"));

            } else {
                int alpha = (int) (255 * (1 - Math.min(0.9, diff - 1)));
                if (mChoose == i) {
                    alpha = 255;
                    mPaint.setColor(Color.parseColor("#B4B4B4"));

                }
                mPaint.setAlpha(alpha);
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);

            }
            canvas.drawText(mLetters[i], mHalfWidth, letterPosY, mPaint);
            canvas.restore();
        }
    }

    private float mInitDownY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIsBeingDragger = false;
                float initDownY = event.getY();
                // 如果点击不在矩形区域内，禁止消费事件
                if (!mIsDownRect.contains(event.getX(), event.getY())) {
                    return false;
                }
                mInitDownY = initDownY;
                break;
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                float diff = Math.abs(y - mInitDownY);
                if (diff > mTouchSlop && !mIsBeingDragger) {
                    mIsBeingDragger = true;
                }
                if (mIsBeingDragger) {
                    mY = y;
                    float moveY = y - getPaddingTop();
                    // 判断移到到的高度是在哪个字母上
                    int character = (int) (moveY / mHalfHeight * mLetters.length);
                    if (mChoose != character) {

                        if (character >= 0 && character < mLetters.length) {
                            // 回调方法
                            mChoose = character;

                            Log.d("选中的字母", mLetters[mChoose]);
                        }
                    }

                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mStartEndAnim = false;
                mIsBeingDragger = false;
                mChoose = -1;
                mAnimStep = 0f;
                invalidate();
                return false;
            default:
        }
        return true;
    }
}
