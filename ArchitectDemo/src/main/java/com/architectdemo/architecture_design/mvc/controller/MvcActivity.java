package com.architectdemo.architecture_design.mvc.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.architectdemo.R;
import com.architectdemo.architecture_design.mvc.other.Callback;
import com.architectdemo.architecture_design.mvc.other.ImageDownloader;
import com.architectdemo.architecture_design.mvc.model.ImageBean;

public class MvcActivity extends AppCompatActivity implements Callback {

    private ImageView imageView;
    private ProgressBar progressBar;
    private final static String PATH = "https://pic.youwu123.net/tpcss/2019/allimg/190208/08135538-23-2401.jpg";
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case ImageDownloader.SUCCESS: // 成功
                    imageView.setImageBitmap((Bitmap) msg.obj);
                    break;

                case ImageDownloader.ERROR: // 失败
                    Toast.makeText(MvcActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
                    break;
                default:

            }
            if (progressBar.getVisibility() == View.VISIBLE) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout 就是 View 层
        setContentView(R.layout.activity_mvc);

        imageView = findViewById(R.id.iv_image);
        progressBar = findViewById(R.id.progressBar);

        // MVC 模式问题，C层与 Model、View 关系太紧密，容易引起 Controller 无法回收导致内存泄漏
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(50000);
            }
        }).start();
    }

    // 点击事件
    public void getImage(View view) {
        ImageBean imageBean = new ImageBean();
        imageBean.setRequestPath(PATH);
        if (progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
        new ImageDownloader().down(this, imageBean);
    }

    @Override
    public void callback(int resultCode, ImageBean imageBean) {
        Message message = handler.obtainMessage(resultCode);
        message.obj = imageBean.getBitmap();
        handler.sendMessageDelayed(message, 500);
    }
}