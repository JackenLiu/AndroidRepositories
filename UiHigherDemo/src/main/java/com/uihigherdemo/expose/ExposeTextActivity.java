package com.uihigherdemo.expose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExposeTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ExposeView(this));
    }
}