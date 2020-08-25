package com.uihigherdemo.explosion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.uihigherdemo.R;

public class ExplosionTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ExplosionView(this));
    }
}