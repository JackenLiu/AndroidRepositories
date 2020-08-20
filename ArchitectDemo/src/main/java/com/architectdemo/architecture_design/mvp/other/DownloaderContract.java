package com.architectdemo.architecture_design.mvp.other;

import com.architectdemo.architecture_design.mvp.model.ImageBean;

// View层交互，Model层交互共同的需求（契约、合同）
public interface DownloaderContract {

    interface M {
        // P层告诉M层，需要做什么事情
        void requestDownloader() throws Exception;
    }

    // V 层与 P 层的交互
    interface PV {
        // V层告诉P层，需要做什么事情
        void requestDownloader();

        // P层得到M层的结果返回，再通知V层
        void responseDownloaderResult(boolean isSuccess, ImageBean imageBean);
    }
}
