package com.uihigherdemo.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;

import com.uihigherdemo.R;

public class EraserView extends View {

    private Bitmap mBeautyBitmap;
    private Paint mPaint;

    private Path mPath;

    public EraserView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mBeautyBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //禁止硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBeautyBitmap, 0, 0, mPaint);

        // 使用离屏绘制 ?
        int layerID = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(createDstDarkBitmap(), 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(createSrcLineBitmap(), 0, 0, paint);


//        paint.setXfermode(null);
//        canvas.restoreToCount(layerID);

    }

    private Bitmap createDstDarkBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(mBeautyBitmap.getWidth(), mBeautyBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAlpha(250);
        canvas.drawRect(0, 0, bitmap.getWidth(), bitmap.getHeight(), mPaint);
        return bitmap;
    }

    private Bitmap createSrcRedBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(mBeautyBitmap.getWidth(), mBeautyBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAlpha(240);
        canvas.drawCircle(300, 300, 300, mPaint);
        return bitmap;
    }

    private Bitmap createSrcLineBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(mBeautyBitmap.getWidth(), mBeautyBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(0xFFFFCC44);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(50);
        mPaint.setAlpha(240);
        canvas.drawPath(mPath, mPaint);
        return bitmap;
    }

    private float mEventX, mEventY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mEventX = event.getX();
                mEventY = event.getY();
                mPath.moveTo(mEventX, mEventY);
                break;
            case MotionEvent.ACTION_MOVE:
                mEventX = event.getX();
                mEventY = event.getY();
                mPath.lineTo(mEventX, mEventY);
                break;
            default:
        }

        invalidate();
        return true;
    }
}
