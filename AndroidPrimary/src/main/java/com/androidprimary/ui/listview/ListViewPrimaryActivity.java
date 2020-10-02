package com.androidprimary.ui.listview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.R;

public class ListViewPrimaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_primary);

        ListView listView = findViewById(R.id.ll);
        listView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 5000;
        }

        @Override
        public Object getItem(int position) {
            // 列表数据里当前位置的 item（bean）
            // return list.get(position);
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                // 说明没有可以重用的 view 对象，需要创建新的 view 对象
                textView = new TextView(ListViewPrimaryActivity.this);
                System.out.println("创建新的对象: " + position + ": " + textView);
            } else {
                // 当前的 convertView 可以被重新使用
                textView = (TextView) convertView;
                System.out.println("重用旧的对象: " + position + ": " + convertView);
            }
            // 给 textView 设置数据
            textView.setText("当前位置：" + position);
            return textView;
        }
    }
}
