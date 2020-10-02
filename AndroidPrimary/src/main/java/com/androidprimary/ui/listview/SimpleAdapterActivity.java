package com.androidprimary.ui.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.androidprimary.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        ListView listView = findViewById(R.id.ll);
        List<Map<String, String>> data = new ArrayList<>();

        // map 中内容 key
        String[] from = {"title", "content", "other"};
        // 内容 key 对应要显示的控件 id
        int[] to = {R.id.tv_title, R.id.tv_content, R.id.tv_other};

        Map<String, String> item1 = new HashMap<>();
        item1.put("title", "title 1111111111");
        item1.put("content", "content 1111111111");
        item1.put("other", "other 1111111111");
        Map<String, String> item2 = new HashMap<>();
        item2.put("title", "title 22222222222");
        item2.put("content", "content 22222222222");
        item2.put("other", "other 22222222222");
        Map<String, String> item3 = new HashMap<>();
        item3.put("title", "title 33333333333");
        item3.put("content", "content 33333333333");
        data.add(item1);
        data.add(item2);
        data.add(item3);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
                R.layout.item_smiple_adapter_activity, from, to);
        listView.setAdapter(simpleAdapter);
    }
}