package com.androidprimary.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.Nullable;

import com.androidprimary.MyApplication;
import com.androidprimary.R;


/**
 * 适配 iPhone ui 原型图 pt 单位的自定义 TextView
 */
public class TextViewFitPt extends androidx.appcompat.widget.AppCompatTextView {

    private int textPtSize;

    public TextViewFitPt(Context context) {
        this(context, null, 0);
    }

    public TextViewFitPt(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextViewFitPt(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewFitPt);
        textPtSize = (int) (typedArray.getInteger(R.styleable.TextViewFitPt_textPtSize, 0) * MyApplication.mDensity);
        // 回收
        typedArray.recycle();
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textPtSize);

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
