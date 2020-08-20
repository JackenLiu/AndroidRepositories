package com.architectdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.architectdemo.architecture_design.mvp.view.MvpActivity;
import com.architectdemo.architecture_design.mvp_extends.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class aClass = LoginActivity.class;
        startActivity(new Intent(this, aClass));

    }
}
