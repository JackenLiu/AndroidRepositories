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
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_api);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.n3);
        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        // 把空图片画到画布上
        Canvas canvas = new Canvas(copyBitmap);
        Matrix matrix = new Matrix();
//        matrix.setRotate(30, copyBitmap.getWidth(), copyBitmap.getHeight());
        matrix.setScale(-1f, 1f);
        matrix.postTranslate(copyBitmap.getWidth(), 0);
        canvas.drawBitmap(bitmap, matrix, new Paint());
        imageView.setImageBitmap(bitmap);
        imageView2.setImageBitmap(copyBitmap);
    }
}