package com.uihigherdemo.xfermode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.uihigherdemo.R;

import java.io.IOException;

public class XferModeTestActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EraserView eraserView = new EraserView(this);
        setContentView(eraserView);

        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;

            Bitmap bitmap = BitmapFactory.decodeStream(
                    getAssets().open("thth.jpg"),
                    null, options);
            Log.d(bitmap.getByteCount() + "", bitmap.getAllocationByteCount() + "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.thth);
        Log.d(bitmap.getByteCount() + "", bitmap.getAllocationByteCount() + "");

    }
}