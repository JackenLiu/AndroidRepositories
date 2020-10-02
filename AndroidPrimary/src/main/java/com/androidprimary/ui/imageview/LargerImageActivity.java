package com.androidprimary.ui.imageview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.androidprimary.R;

public class LargerImageActivity extends AppCompatActivity {

    private ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger_image);

        // options 对象在解码图片的时候进行压缩比例
        BitmapFactory.Options options = new BitmapFactory.Options();
        /*
        代表宽度和高度都是原图的 1/2，总大小是原图的 1/4
        如果传入的数不是 2 的幂指数，则取最接近的
         */
        options.inSampleSize = 14;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.macbg, options);

        Log.d("bitmap 原图大小", bitmap.getAllocationByteCount() + "");

        imageView = findViewById(R.id.imageView);
//        imageView.setImageBitmap(bitmap);

//        loadFitInSampleSize();
        infiniteTry();
    }


    /**
     * 加载（获取最适合的）inSampleSize
     * 原理是通过屏幕分辨率与图片分辨率的宽高比
     */
    private void loadFitInSampleSize() {
        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

        Log.d("LargerImageActivity: ", "屏幕宽高：" + screenWidth + "," + screenHeight);

        BitmapFactory.Options options = new BitmapFactory.Options();
        /*
        只解析图片的宽高以及类型
        设为 true 代表 BitmapFactory.decode... 只会把图片的宽高、图片类型读取出来，不会解码图片到内存
         */
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.macbg, options);
        if (bitmap == null) {
            Log.d("bitmap 大小: ", options.outWidth + "," + options.outHeight);
        }

        int width = options.outWidth;
        int height = options.outHeight;

        // 只有当图片的宽度和高度大于屏幕的宽高才压缩
        if (width > screenWidth || height > screenHeight) {
            int widthIndex = Math.round(width / screenWidth);
            int heightIndex = Math.round(height / screenHeight);
            options.inSampleSize = Math.max(widthIndex, heightIndex);
            Log.d("inSampleSize 大小: ", options.inSampleSize + "");
        }

        // 把图片开始加载到内存
        options.inJustDecodeBounds = false;
        // 因为 options 变了，所以要使用新的 options 重新获取 bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.macbg, options);
        imageView.setImageBitmap(bitmap);
    }

    /**
     * TODO
     * 无限测试出不会出现 OOM 异常的 inSampleSize(方法有问题，或许是图片在 mipmap中的原因，视频是加载内存卡图)
     */
    private void infiniteTry() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        Bitmap bitmap;
        int i = 1;
        for (; ; ) {
            options.inSampleSize = i;
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.macbg, options);
                imageView.setImageBitmap(bitmap);
                break;
            } catch (Exception e) {
                i *= 2;
                Log.d("i 大小: ", i + "");
            } catch (Error error) {
                i *= 2;
                Log.d("i 大小: ", i + "");
            }
        }
    }
}