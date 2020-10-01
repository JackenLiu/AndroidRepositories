package com.androidprimary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.activity.A_Activity;
import com.androidprimary.aidl.AidlActivity;
import com.androidprimary.ui.listview.ListViewActivity;
import com.androidprimary.view.touch.TouchSystemActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Class aClass = AidlActivity.class;
//        Class aClass = TouchSystemActivity.class;
        Class aClass = A_Activity.class;

        startActivity(new Intent(this, aClass));

    }
}