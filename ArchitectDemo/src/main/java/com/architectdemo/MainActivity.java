package com.architectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.architectdemo.architecture_design.mvc.controller.MvcActivity;
import com.architectdemo.architecture_design.mvp.view.MvpActivity;
import com.architectdemo.architecture_design.mvp_extends.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Class aClass = LoginActivity.class;
        startActivity(new Intent(this, aClass));

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, aClass));
            }
        });
    }
}
