package com.architectdemo.architecture_design.mvp.presenter;

import android.os.SystemClock;

import com.architectdemo.architecture_design.mvp.other.DownloaderContract;
import com.architectdemo.architecture_design.mvp.view.MvpActivity;
import com.architectdemo.architecture_design.mvp.other.engine.DownLoaderEngine;
import com.architectdemo.architecture_design.mvp.model.ImageBean;

// P层几乎不做事情？谷歌的sample中，P层是包揽了所有的活
public class DownLoaderPresenter implements DownloaderContract.PV {

    private MvpActivity view;
    private DownLoaderEngine model; // 下载的模型

    public DownLoaderPresenter(MvpActivity view) {
        this.view = view;
        model = new DownLoaderEngine(this);
    }

    @Override
    public void requestDownloader() {
        // 接收到 View层的指令，去完成某个需求（可以自己完成，也可以让别人去完成）
        try {
            model.requestDownloader();
        } catch (Exception e) {
            e.printStackTrace();
            // 省略了异常的处理
        }

        // MVP 模式问题，P 层与 View 关系还是存在引用关系，容易引起 View 无法回收导致内存泄漏
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(50000);
            }
        }).start();
    }

    @Override
    public void responseDownloaderResult(final boolean isSuccess, final ImageBean imageBean) {
        // 将完成的结果告知View层（刷新UI）
        view.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.responseDownloaderResult(isSuccess, imageBean);
            }
        });
    }
}
