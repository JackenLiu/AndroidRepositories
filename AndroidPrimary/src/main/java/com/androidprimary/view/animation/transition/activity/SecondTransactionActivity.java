package com.androidprimary.view.animation.transition.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.androidprimary.R;

public class SecondTransactionActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_second);
        int resId = getIntent().getExtras().getInt("resId");
        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setTransitionName("img");
        iv.setImageResource(resId);

        Transition transition = new Explode();
        transition.excludeTarget(android.R.id.statusBarBackground, true);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
    }

}
