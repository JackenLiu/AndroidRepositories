package com.uihigherdemo.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SkewTextView extends View {
    private Paint paint;
    private float fSkewY = -0.15f;

    public SkewTextView(Context context) {
        super(context);
        init();

    }

    public SkewTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public SkewTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.skew(0, fSkewY);
        canvas.drawText("好说歹说酷酷酷可靠的反垄断法", 0, 80, paint);
        if (fSkewY >= -0.15f) {
            fSkewY += 0.001;
        }

        if (fSkewY >= 0) {
            fSkewY = -0.15f;
        }

        invalidate();
    }

//    public void upDateSkew(float skewY) {
//        if (skewY > 0.15) {
//            // 最大值
//            fSkewY = 0.15f;
//        } else if (fSkewY < -0.15) {
//            fSkewY = -0.15f;
//        } else {
//            fSkewY = skewY;
//        }
//        invalidate();
//        fSkewY -= 0.01;
//        upDateSkew(fSkewY);
//        if (fSkewY == 0) {
//            return;
//        }
//    }
}
