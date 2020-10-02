package com.androidprimary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.ui.image.DrawImageActivity;
import com.androidprimary.ui.image.ImageApiActivity;
import com.androidprimary.ui.imageview.LargerImageActivity;
import com.androidprimary.ui.listview.ArrayAdapterActivity;
import com.androidprimary.ui.listview.ListViewComplexActivity;
import com.androidprimary.ui.listview.ListViewPrimaryActivity;
import com.androidprimary.ui.listview.SimpleAdapterActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Class aClass = AidlActivity.class;
//        Class aClass = TouchSystemActivity.class;
//        Class aClass = ListViewExtendsActivity.class;
//        Class aClass = ListViewPrimaryActivity.class;
//        Class aClass = ListViewComplexActivity.class;
//        Class aClass = ArrayAdapterActivity.class;
//        Class aClass = SimpleAdapterActivity.class;
//        Class aClass = A_Activity.class;
//        Class aClass = LargerImageActivity.class;
//        Class aClass = ImageApiActivity.class;
        Class aClass = DrawImageActivity.class;

        startActivity(new Intent(this, aClass));

    }
}