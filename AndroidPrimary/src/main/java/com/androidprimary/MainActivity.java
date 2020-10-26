package com.androidprimary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.ui.image.DrawImageActivity;
import com.androidprimary.ui.image.ImageApiActivity;
import com.androidprimary.ui.imageview.LargerImageActivity;
import com.androidprimary.ui.listview.ArrayAdapterActivity;
import com.androidprimary.ui.listview.ListViewComplexActivity;
import com.androidprimary.ui.listview.ListViewPrimaryActivity;
import com.androidprimary.ui.listview.SimpleAdapterActivity;
import com.androidprimary.ui.video.SurfaceViewVideoActivity;
import com.androidprimary.ui.video.VideoViewActivity;
import com.androidprimary.ui.viewpager.ViewPagerActivity;
import com.androidprimary.view.animation.primary.frame.FrameAnimationActivity;
import com.androidprimary.view.animation.primary.property.PropertyActivity;
import com.androidprimary.view.animation.primary.view.ViewAnimationHeiMaActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Class aClass = AidlActivity.class;
//        Class aClass = TouchSystemActivity.class;
//        Class aClass = ListViewExtendsActivity.class;
//        Class aClass = ListViewPrimaryActivity.class;
        Class aClass = ListViewComplexActivity.class;
//        Class aClass = ArrayAdapterActivity.class;
//        Class aClass = SimpleAdapterActivity.class;
//        Class aClass = A_Activity.class;
//        Class aClass = LargerImageActivity.class;
//        Class aClass = ImageApiActivity.class;
//        Class aClass = DrawImageActivity.class;
//        Class aClass = SurfaceViewVideoActivity.class;
//        Class aClass = VideoViewActivity.class;
//        Class aClass = FrameAnimationActivity.class;
//        Class aClass = PropertyActivity.class;
//        Class aClass = ViewAnimationHeiMaActivity.class;
//        Class aClass = ViewPagerActivity.class;

        startActivity(new Intent(this, aClass));

    }

    public void a(View view) {
        TextView view1 = (TextView) view;
        view1.setText("就是简单的的");
    }

    public void b(View view) {
        TextView view1 = (TextView) view;
        view1.setText("就是简单的的");
    }

    public void c(View view) {
        TextView view1 = (TextView) view;
        view1.setText("就是简单的的第三方");
    }
}