package com.androidprimary.ui.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidprimary.R;

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        ListView listView = findViewById(R.id.ll);
        String[] ss1 = {"是是的", "几份文件", "desdf", "几份缩短文件", "十大歌手都", "施工方发送到", "收到"};

        /*
        简单布局，只有一个 TextView 或者只改变一个 TextView 的情况下使用
         */
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, R.layout.item_array_adapter1_activity, ss1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, R.layout.item_array_adapter2_activity, R.id.tv, ss1);
//        listView.setAdapter(adapter1);
        listView.setAdapter(adapter2);
    }
}