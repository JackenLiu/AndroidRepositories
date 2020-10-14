package com.example.customwidget.alphabetNavigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;

import com.example.customwidget.DimensionsUtil;

public class HorizontalSlideLetterNavigationView extends View {
    private Context mContext;

    private String[] mLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    private Paint mPaint;
    /**
     * 触发移动事件的最小距离，自定义 View 处理 touch 事件的时候，有的时候需要判断用户是否真的存在 movie，
     * 系统提供了这样的方法。表示滑动的时候，手的移动要大于这个返回的距离值才开始移动控件。
     */
    private int mTouchSlop;
    private float mDensity;

    /**
     * 控件减去边距宽度
     */
    private float mWholeWidth;
    /**
     * 控件减去边距高度
     */
    private float mWholeHeight;

    private float mLetterWidth;

    /**
     * 字母点击拖动区域
     */
    private RectF mIsDownRect = new RectF();

    private int intChooseIndex;
    private float touchX;
    private boolean mIsBeingDragger, mStartEndAnim;

    private int oneCharactorWidth;

    public HorizontalSlideLetterNavigationView(Context context) {
        this(context, null);
    }

    public HorizontalSlideLetterNavigationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalSlideLetterNavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#666666"));

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mDensity = getContext().getResources().getDisplayMetrics().density;

        // 初始化好文字
        int textSize = DimensionsUtil.sp2px(context, 13);
        mPaint.setTextSize(textSize);
        Rect rect = new Rect();
        // 测量文本大小，将文本大小信息存放在rect中
        mPaint.getTextBounds("#", 0, "#".length(), rect);
        // 因为刚初始化，所以肯定是正数
        oneCharactorWidth = rect.right;

        // 设置控件边距，注意包括半个文字宽度
        setPadding(DimensionsUtil.sp2px(context, 40), 0,
                DimensionsUtil.sp2px(context, 40), 0);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.d("边距： ", getPaddingLeft() + "," + getPaddingRight());
        mWholeWidth = w - getPaddingLeft() - getPaddingRight();
        mWholeHeight = h - DimensionsUtil.dp2px(mContext, 73);
        Log.d("宽高： ", mWholeWidth + "," + mWholeHeight);

        /**
         * 注意，需要减去一个字符宽度才准确
         */
        mLetterWidth = (mWholeWidth - oneCharactorWidth) / (mLetters.length - 1);

        // 设置点击区域矩形范围
        mIsDownRect.set(
                getPaddingLeft(),
                DimensionsUtil.sp2px(mContext, 40),
                mWholeWidth + getPaddingLeft(),
                DimensionsUtil.sp2px(mContext, 100)
        );
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mLetters.length; i++) {
            // 单个字母下的 x 坐标
            float letterPosX = mLetterWidth * i + getPaddingLeft();
            // 字母放大倍数
            float diff;

            // 当前字母被选中（顶点）
            if (intChooseIndex == i && i != 0 && i != mLetters.length - 1) {
                // 选中的字母放大 2.2 倍
                diff = 2.0f;

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
//                float maxPos = Math.abs(touchY - letterPosY) / mWholeHeight * 7;
                float maxPos = Math.abs(touchX - letterPosX) / mWholeWidth * 10;

                // maxPos 要小于 1.2 才会取 2.2f - maxPos 的值
                diff = Math.max(1f, 2.0f - maxPos);


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
            }

            canvas.save();
            canvas.scale(diff, diff, letterPosX, DimensionsUtil.dp2px(mContext, 88));

            if (diff == 1f) { // 未选中
                mPaint.setAlpha(255);
                mPaint.setTypeface(Typeface.DEFAULT);
                mPaint.setColor(Color.parseColor("#666666"));

            } else { // 弧线范围
                int alpha = (int) (255 * (1 - Math.min(0.9, diff - 1)));
                if (intChooseIndex == i) { // 选中
                    alpha = 255;
                    mPaint.setColor(Color.parseColor("#B4B4B4"));
                }
                mPaint.setAlpha(alpha);
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);

            }

            // 外面回调接口，设置选中的文字效果
            if (isBeginSelectLetterFromOutSide && mLetters[i].equals(strSelectLetter)) {
                mPaint.setColor(Color.parseColor("#B4B4B4"));
                mPaint.setTextSize(DimensionsUtil.sp2px(mContext, 22));
                Paint.FontMetrics metrics = mPaint.getFontMetrics();
                float baseY = Math.abs(metrics.ascent + metrics.descent) / 2;

                canvas.drawText(mLetters[i],
                        letterPosX - mPaint.measureText(strSelectLetter) / 4,
                        DimensionsUtil.dp2px(mContext, 73) + baseY / 4,
                        mPaint);
            } else { // 设置没选中的文字
                mPaint.setTextSize(DimensionsUtil.sp2px(mContext, 13));

                canvas.drawText(mLetters[i],
                        letterPosX, DimensionsUtil.dp2px(mContext, 73),
                        mPaint);
            }

            canvas.restore();
        }

//        mPaint.setColor(Color.BLUE);
//        mPaint.setAlpha(60);
//        canvas.drawRect(mIsDownRect, mPaint);
    }


    private float mInitDownX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 外面回调接口
                isBeginSelectLetterFromOutSide = false;

                mIsBeingDragger = false;
                float initDownX = event.getX();
                // 如果点击不在矩形区域内，禁止消费事件
                if (!mIsDownRect.contains(event.getX(), event.getY())) {
                    return false;
                }
                mInitDownX = initDownX;
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float diff = Math.abs(x - mInitDownX);
                if (diff > mTouchSlop && !mIsBeingDragger) {
                    mIsBeingDragger = true;
                }
                if (mIsBeingDragger) {
                    touchX = x;
                    float moveX = x - getPaddingLeft();
                    // 判断移到到的高度是在哪个字母上
                    int character = (int) (moveX / mWholeWidth * mLetters.length);
                    if (intChooseIndex != character) {

                        if (character >= 0 && character < mLetters.length) {
                            // 回调方法
                            intChooseIndex = character;

                            Log.d("选中的字母", mLetters[intChooseIndex]);
                        }
                    }

                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setSelectLetter(mLetters[intChooseIndex]);

                mStartEndAnim = false;
                mIsBeingDragger = false;
                intChooseIndex = -1;
                invalidate();
                return false;
            default:
        }
        return true;
    }


    private boolean isBeginSelectLetterFromOutSide = false;
    private String strSelectLetter;

    public void setSelectLetter(String letter) {
        strSelectLetter = letter;
        invalidate();
        isBeginSelectLetterFromOutSide = true;
    }
}
