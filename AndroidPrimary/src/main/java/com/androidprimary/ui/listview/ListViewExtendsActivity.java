package com.androidprimary.ui.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidprimary.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewExtendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(new MyAdapter());
    }


    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) {
                Log.d("------", convertView.getHeight() + "");
            }

            if (position % 2 == 0) {
                return getItem1View(convertView, position);
            } else {
                return getItem2View(convertView, position);
            }
        }
    }

    View getItem1View(View convertView, int position) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.listview_item_1, null);
            holder.iv = convertView.findViewById(R.id.iv);
            holder.item1_tv = convertView.findViewById(R.id.tv1);
            convertView.setTag(holder);

        } else {
            /*
            如果这里不使用 ViewHolder ，则会出现大量重复代码
            ImageView iv = convertView.findViewById(R.id.iv);
            iv.setImageResource(R.drawable.color_tab_icon_me);
            ...
             */
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv.setImageResource(R.drawable.color_tab_icon_me);
        holder.item1_tv.setText("带图片的：" + position);
        return convertView;
    }

    View getItem2View(View convertView, int position) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.listview_item_2, null);
            holder.item2_tv = convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.item2_tv.setText("不图片的" + position);

        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView item1_tv;
        TextView item2_tv;
    }
}