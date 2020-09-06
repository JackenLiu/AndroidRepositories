package com.uihigherdemo;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.uihigherdemo.explosion.ExplosionTextActivity;
import com.uihigherdemo.expose.ExposeTextActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final Class toActivity = XferModeTestActivity.class;
//        final Class toActivity = ExplosionTextActivity.class;
        final Class toActivity = ExposeTextActivity.class;

        startActivity(new Intent(this, toActivity));
    }
}
