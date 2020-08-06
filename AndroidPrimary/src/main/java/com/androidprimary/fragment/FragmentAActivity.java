package com.androidprimary.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidprimary.R;

public class FragmentAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_a);

        /*
        静态加载
         */
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentAActivity.this, FragmentBActivity.class));
            }
        });

        /*
        动态加载
         */
        Afragment afragment = Afragment.getInstance("好还是");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ll1, afragment)
                .commit();
        // Fragment 回调数据
        afragment.setOnClickListener(new Afragment.OnCliclListener() {
            @Override
            public void onClick(String s) {
                setTitle(s);
            }
        });

        Afragment afragment1 = Afragment.getInstance("ffhg");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ll2, afragment1)
//                .remove()
//                .replace()
                .commit();
        // Fragment 回调数据
        afragment1.setOnClickListener(new Afragment.OnCliclListener() {
            @Override
            public void onClick(String s) {
                setTitle(s);
            }
        });
    }

}