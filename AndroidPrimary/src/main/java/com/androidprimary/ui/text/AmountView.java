package com.androidprimary.ui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


/**
 * @Description
 * @Author 刘家权（Jacken Liu）
 * @Time 11/19/20 11:25 AM
 */
public class AmountView extends View {

    private Paint amountPaint;

    private Rect rect;

    private int wholeW;
    private int wholeH;

    private String text = "¥100";
    private Typeface typeface = null;
    private int textSize = 120;
    private int textColor = Color.WHITE;

    public AmountView(Context context) {
        super(context);
        init();
    }

    public AmountView(Context context, String text, Typeface typeface, int textSize, int textColor) {
        super(context);
        this.text = text;
        this.typeface = typeface;
        this.textSize = textSize;
        this.textColor = textColor;
        init();
    }


    public AmountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AmountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        amountPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        amountPaint.setTypeface(typeface);
        amountPaint.setTextSize(textSize);
        amountPaint.setColor(textColor);

        rect = getTextRectByTypeface(text, textSize, typeface);

        wholeH = getCharHeight(rect);
        wholeW = getCharWidth(rect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        canvas.drawText(text, 0, getCharHeight(rect), amountPaint);
        canvas.translate(0, getCharHeight(rect));
        amountPaint.setAlpha(100);
        canvas.drawRect(rect, amountPaint);
    }

    public int getWholeW() {
        return wholeW;
    }

    public int getWholeH() {
        return wholeH;
    }

    public Rect getTextRectByTypeface(String text, int textSize, Typeface type) {
        Paint paint = new Paint();
        if (type != null)
            paint.setTypeface(type);
        paint.setTextSize(textSize);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    private int getCharWidth(Rect textRect) {
        return textRect.right - textRect.left;
    }

    private int getCharHeight(Rect textRect) {
        return textRect.bottom - textRect.top;
    }

    /**
     * 使用 Paint 画的中文和英文高度是有差别的
     *
     * @param textSize
     * @param type
     * @return
     */
    private int getChineseEnglishHeightOffset(int textSize, Typeface type) {
        Paint paint = new Paint();
        if (type != null)
            paint.setTypeface(type);
        paint.setTextSize(textSize);

        Rect rect = new Rect();
        paint.getTextBounds("A", 0, 1, rect);
        int englishHeight = Math.abs(rect.bottom - rect.top);
        paint.getTextBounds("我", 0, 1, rect);
        int chineseHeight = Math.abs(rect.bottom - rect.top);
        return chineseHeight - englishHeight;
    }
}
