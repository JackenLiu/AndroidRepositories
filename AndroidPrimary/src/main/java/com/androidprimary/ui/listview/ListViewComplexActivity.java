package com.androidprimary.ui.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.androidprimary.R;

public class ListViewComplexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_complex);

        ListView listView = findViewById(R.id.ll);
        listView.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            第一个参数 上下文
            第二个参数 布局 id
            第三个参数 ViewGroup (比如 LinerLayout)，如果 ViewGroup 传入一个具体对象，那么这个方法创建出来的
            View 对象就会作为这个 ViewGroup 的一个 childView ，现在只是把 xml 文件转换成 View 对象，不需要放到
            ViewGroup 中，所以传 null
             */
            View view;
            if (convertView == null) {
                view = View.inflate(ListViewComplexActivity.this, R.layout.item_complex_activity, null);
            } else {
                view = convertView;
            }

            return view;
        }
    }

}