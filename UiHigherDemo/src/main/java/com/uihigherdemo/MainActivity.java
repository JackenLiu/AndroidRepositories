package com.uihigherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.uihigherdemo.explosion.ExplosionTextActivity;
import com.uihigherdemo.xfermode.EraserView;
import com.uihigherdemo.xfermode.XferModeTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final Class toActivity = XferModeTestActivity.class;
        final Class toActivity = ExplosionTextActivity.class;

        startActivity(new Intent(this, toActivity));
    }
}
