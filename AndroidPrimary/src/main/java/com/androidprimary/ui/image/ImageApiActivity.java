package com.androidprimary.ui.image;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;

import com.androidprimary.R;

public class ImageApiActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_api);

        imageView = findViewById(R.id.imageView);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.n0);
        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        // 把空图片画到画布上
        Canvas canvas = new Canvas(copyBitmap);
        Matrix matrix = new Matrix();
//        matrix.setRotate(30, copyBitmap.getWidth(), copyBitmap.getHeight());
        matrix.setScale(1.5f, 1f);
//        matrix.preTranslate(100, 150);
        canvas.drawBitmap(bitmap, matrix, new Paint());
        imageView.setImageBitmap(copyBitmap);
    }
}