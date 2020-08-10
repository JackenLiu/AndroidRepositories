package com.androidprimary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.view.animation.transition.scene.SceneActivity;
import com.androidprimary.view.surfaceview.SurfaceViewActivity;
import com.androidprimary.view.surfaceview.SurfaceViewTemplate;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class aClass = SurfaceViewActivity.class;

        startActivity(new Intent(this, aClass));
    }
}