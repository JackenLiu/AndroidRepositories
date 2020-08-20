package com.architectdemo.architecture_design.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.architectdemo.R;
import com.architectdemo.architecture_design.mvvm.vm.LoginViewModel;
import com.architectdemo.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);

        // 1、必须先ReBuilder，2、书写代码绑定
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);

        new LoginViewModel(binding);
    }
}