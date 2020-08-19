package com.architectdemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.architectdemo.MainActivity;
import com.architectdemo.R;

public class HandlerActivity extends AppCompatActivity {

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    });
    private TextView textView;


    private Handler handler1 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.d("handler1 创建线程：", Thread.currentThread().getName());
            Log.d("handler1 handleMessage 线程：", Thread.currentThread().getName());
            return false;
        }
    });

    private Handler handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        textView = findViewById(R.id.textView);

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



        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(HandlerActivity.this, "靠", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();


        /*
        ----- start ----- 验证 “ handleMessage 所在线程是由 Looper 决定而不是 Handler 创建决定”
         */
        new Thread() {
            @Override
            public void run() {
                Log.d("handler2 创建线程：", Thread.currentThread().getName());

                handler2 = new Handler(getMainLooper(), new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message msg) {
                        Log.d("handler2 handleMessage 线程：", Thread.currentThread().getName());
                        return false;
                    }
                });
            }
        }.start();
        handler1.sendEmptyMessage(1);
        SystemClock.sleep(100);
        handler2.sendEmptyMessage(1);
        /*
        ----- end ----- 验证 “ handleMessage 所在线程是由 Looper 决定而不是 Handler 创建决定”
         */
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread() {
            @Override
            public void run() {
                /*
                · 加上阻塞则崩溃，因为会在 ViewRootImpl.checkThread() 去检查是否是主线程
                · 不加则不会，原因是因为代码执行的速度快于 ViewRootImpl.checkThread() 执行的速度
                 */
//                SystemClock.sleep(1000);
                textView.setText("www");
            }
        }.start();
    }
}