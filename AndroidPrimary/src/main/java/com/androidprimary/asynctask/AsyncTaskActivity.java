package com.androidprimary.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidprimary.R;

public class AsyncTaskActivity extends AppCompatActivity {
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = findViewById(R.id.tv);
        textView1 = findViewById(R.id.tv1);

        new DownloadAsyncTask().execute("a", "b");

    }

    class DownloadAsyncTask extends AsyncTask<String, Integer, Boolean> {

        /*
        异步线程之前执行，在主线程中
         */
        @Override
        protected void onPreExecute() {
            textView.setText("onPreExecute");
        }

        /*
        新的异步线程 耗时操作
        */
        @Override
        protected Boolean doInBackground(String... strings) {
            for (int i = 0; i < 10000; i++) {
                if (i == 0 || i % 2000 == 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(i);
                }
                Log.d(i + "===========", strings[0]);
                textView.setText(i + "===========" + strings[0]);
            }
            return true;
        }

        /*
        异步线程之后执行，在主线程中
         */
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean)
                textView.setText("onPostExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView1.setText("进度：" + values[0]);
        }
    }

}