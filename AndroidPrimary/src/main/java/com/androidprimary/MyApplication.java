package com.androidprimary;

import android.app.Application;
import android.util.DisplayMetrics;

public class MyApplication extends Application {
    public static float mDensity;

    @Override
    public void onCreate() {
        super.onCreate();


        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
    }
}
