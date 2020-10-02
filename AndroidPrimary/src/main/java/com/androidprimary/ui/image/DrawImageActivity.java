package com.androidprimary.ui.image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.androidprimary.MainActivity;
import com.androidprimary.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DrawImageActivity extends AppCompatActivity {

    private Paint paint;
    private float startX = 0;
    private float startY = 0;
    private Bitmap copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_image);

        final ImageView iv = findViewById(R.id.imageView);
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.drawable.sample);

        copy = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        final Canvas canvas = new Canvas(copy);
        paint = new Paint();
        paint.setStrokeWidth(15);
        // 将原图画进去 Canvas 的 Bitmap
        canvas.drawBitmap(src, new Matrix(), paint);
        // 将 Canvas 的 Bitmap 显示出来
        iv.setImageBitmap(copy);


        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 将原图画进去 Canvas 的 Bitmap 后的基础上，画线
                        canvas.drawLine(startX, startY, event.getX(), event.getY(), paint);
                        startX = event.getX();
                        startY = event.getY();
                        // 将 Canvas 的 Bitmap 显示出来
                        iv.setImageBitmap(copy);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void save(View view) {
        /*
        需要获取权限
        高版本还需在 Manifest 中添加 sd 卡权限和 requestLegacyExternalStorage
         */
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
        } else {
            File file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".png");
            try {
                FileOutputStream stream = new FileOutputStream(file);
                /*
                保存
                参数 1 ：格式
                参数 2 ：质量，100 代表最高
                参数 3 ：输入流
                 */
                copy.compress(Bitmap.CompressFormat.PNG, 100, stream);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}