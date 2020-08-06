package com.androidprimary.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidprimary.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HandlerActivity extends AppCompatActivity {

    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        download("https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe");
                    }
                }.start();
            }
        });

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 10001) {
                    progressBar.setProgress((Integer) msg.obj);
                }
            }
        };
    }

    private void download(String theUrl) {
        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            int contentLength = urlConnection.getContentLength();
            String folderName = Environment.getExternalStorageDirectory()
                    + File.separator + "wechat" + File.separator;
            File file = new File(folderName);
            if (!file.exists()) {
                file.mkdir();
            }

            String fileName = folderName + "Wechat.exe";
            File exeFile = new File(fileName);

            if (exeFile.exists()) {
                exeFile.delete();
            }

            int downloadSize = 0;
            byte[] bytes = new byte[1024];
            int length;

            OutputStream outputStream = new FileOutputStream(fileName);
            Log.d("1", "1111111111");

            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
                downloadSize += length;

                Message message = Message.obtain();
                message.what = 10001;
                message.obj = downloadSize * 100 / contentLength;
                mHandler.sendMessage(message);
                Log.d("1", "1111111111");
            }
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            Log.d("Exception", "1111111111");

            e.printStackTrace();
        }

    }
}