package com.androidprimary.ui.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidprimary.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String s = getIntent().getStringExtra("FirstActivity");
        setTitle(s);
        setResult(RESULT_OK, new Intent().putExtra("SecondActivity", "从 SecondActivity 回来"));
    }
}