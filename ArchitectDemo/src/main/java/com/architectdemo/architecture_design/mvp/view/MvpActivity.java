package com.architectdemo.architecture_design.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.architectdemo.R;
import com.architectdemo.architecture_design.mvp.other.DownloaderContract;
import com.architectdemo.architecture_design.mvp.model.ImageBean;
import com.architectdemo.architecture_design.mvp.presenter.DownLoaderPresenter;

public class MvpActivity extends AppCompatActivity implements DownloaderContract.PV {

    private ImageView imageView;
    private ProgressBar progressBar;

    private DownLoaderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        imageView = findViewById(R.id.iv);
        progressBar = findViewById(R.id.progressBar);

        presenter = new DownLoaderPresenter(this);
    }

    // 点击事件
    public void down(View view) {
        if (progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
        requestDownloader();
    }

    @Override
    public void requestDownloader() {
        if (presenter != null) presenter.requestDownloader();
    }

    @Override
    public void responseDownloaderResult(boolean isSuccess, ImageBean imageBean) {
        Toast.makeText(this, isSuccess ? "下载成功" : "下载失败", Toast.LENGTH_SHORT).show();
        if (isSuccess && imageBean.getBitmap() != null) {
            imageView.setImageBitmap(imageBean.getBitmap());
        }
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}