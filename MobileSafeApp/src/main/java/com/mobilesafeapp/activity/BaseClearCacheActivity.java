package com.mobilesafeapp.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost.TabSpec;

import com.mobilesafeapp.R;

public class BaseClearCacheActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_clear_cache);


        TabSpec tab1 = getTabHost().newTabSpec("clear_cache").setIndicator("选项卡1");
        tab1.setContent(new Intent(getApplicationContext(), ClearCacheActivity.class));

        TabSpec tab2 = getTabHost().newTabSpec("sd_clear_cache").setIndicator("选项卡2");
        tab2.setContent(new Intent(getApplicationContext(), SDClearCacheActivity.class));

        getTabHost().addTab(tab1);
        getTabHost().addTab(tab2);
    }
}
