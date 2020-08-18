package com.architectdemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.architectdemo.R;

public class HandlerActivity extends AppCompatActivity {

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        final TextView textView = findViewById(R.id.textView);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("2000");
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("5000");
            }
        }, 5000);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("0000");
            }
        });
    }
}