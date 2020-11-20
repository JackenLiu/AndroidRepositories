package com.androidprimary.ui.text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.androidprimary.R;

public class DiffTextSizeActivity extends AppCompatActivity {

    class MyTextView extends View {
        Paint paint = new Paint();

        public MyTextView(Context context) {
            super(context);
            paint.setTypeface(getAyoHematTinta("fonts/Curvilingus-ywwV5.ttf"));
            paint.setTextSize(200);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Rect rect = new Rect();
            paint.getTextBounds("¥100ABC", 0, "¥100ABC".length(), rect);
            canvas.drawText("¥100ABC", 200, 200, paint);
            paint.setAlpha(100);
            canvas.translate(200, 200);
            canvas.drawRect(rect, paint);
        }

        public Typeface getAyoHematTinta(String path) {
            AssetManager mgr = getAssets();
            //根据路径得到 Typeface
            Typeface tf = Typeface.createFromAsset(mgr, path);
            return tf;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new MyTextView(this));

        AmountView amountView = new AmountView(this);
        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(amountView);

        setContentView(layout);

//        Paint paint = new Paint();
//        paint.setTypeface(getAyoHematTinta("fonts/AyoHematTinta-mLlGV.otf"));
//        paint.setTextSize(100);

        Rect rect = getTextRectByTypeface("ABC", 100,
                getAyoHematTinta("fonts/AyoHematTinta-mLlGV.otf"));
        Log.d("所有字体宽高：", getCharWidth(rect, 1) + "," + getCharHeight(rect));
        Log.d("单个字体宽高：", getCharWidth(rect, 3) + "," + getCharHeight(rect));
    }

    public Typeface getAyoHematTinta(String path) {
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        Typeface tf = Typeface.createFromAsset(mgr, path);
        return tf;
    }

    public Rect getTextRectByTypeface(String text, int textSize, Typeface type) {
        Paint paint = new Paint();
        paint.setTypeface(type);
        paint.setTextSize(textSize);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    private int getCharWidth(Rect textRect, int charNum) {
        return (textRect.right - textRect.left) / charNum;
    }

    private int getCharHeight(Rect textRect) {
        return textRect.bottom - textRect.top;
    }
}