package com.uihigherdemo;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.uihigherdemo.animation.TestSkewActivity;
import com.uihigherdemo.event.SlideConflictActivity;
import com.uihigherdemo.explosion.ExplosionTextActivity;
import com.uihigherdemo.expose.ExposeTextActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final Class toActivity = XferModeTestActivity.class;
//        final Class toActivity = ExplosionTextActivity.class;
//        final Class toActivity = ExposeTextActivity.class;
//        final Class toActivity = SlideConflictActivity.class;
        final Class toActivity = TestSkewActivity.class;

        startActivity(new Intent(this, toActivity));
    }
}
