package com.architectdemo.architecture_design.mvvm_principle.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.architectdemo.R;
import com.architectdemo.architecture_design.mvvm_principle.databinding.model.UserInfo;
import com.architectdemo.databinding.ActivityMvvmPrincipleBinding;

public class MvvmPrincipleActivity extends AppCompatActivity {

    private UserInfo userInfo = new UserInfo();
    private final static String TAG = "netease >>> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMvvmPrincipleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_principle);

        // 单向绑定第一种方式：<Model -- View>
//        userInfo.setUsername("彭老师");
//        userInfo.setPassword("163");
//        binding.setUser(userInfo);
//
//        // 数据的刷新？无效果
//        Log.e(TAG, userInfo.getUsername() + " / " + userInfo.getPassword());
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                userInfo.setUsername("西西老师");
//                userInfo.setPassword("187");
//                Log.e(TAG, userInfo.getUsername() + " / " + userInfo.getPassword());
//            }
//        }, 3000);

        // 单向绑定第二种方式：<Model -- View>
//        userInfo.username.set("彭老师");
//        userInfo.password.set("163");
//        binding.setUser(userInfo);
//        Log.e(TAG, userInfo.username.get() + " / " + userInfo.password.get());
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                userInfo.username.set("西西老师");
//                userInfo.password.set("187");
//                Log.e(TAG, userInfo.username.get() + " / " + userInfo.password.get());
//            }
//        }, 3000);

        // 双向绑定(Model --- View     View  --- Model)
        userInfo.username.set("彭老师");
        userInfo.password.set("163");
        binding.setUser(userInfo);

        Log.e(TAG, userInfo.username.get() + " / " + userInfo.password.get());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, userInfo.username.get() + " / " + userInfo.password.get());
            }
        }, 20000);
    }
}