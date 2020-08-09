package com.androidprimary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.androidprimary.animation.primary.frame.FrameAnimationActivity;
import com.androidprimary.animation.primary.property.PropertyActivity;
import com.androidprimary.animation.primary.view.ViewAnimationActivity;
import com.androidprimary.animation.transition.activity.FirstTransactionActivity;
import com.androidprimary.animation.transition.reveal.RevealActivity;
import com.androidprimary.animation.transition.scene.SceneActivity;
import com.androidprimary.asynctask.DownloadActivity;
import com.androidprimary.dialog.AlertDialogActivity;
import com.androidprimary.dialog.PopupWindowActivity;
import com.androidprimary.fragment.FragmentAActivity;
import com.androidprimary.intent.FirstActivity;
import com.androidprimary.layout.ConstraintLayoutActivity;
import com.androidprimary.menu.ContextMenuActivity;
import com.androidprimary.menu.OptionMenuActivity;
import com.androidprimary.menu.PopupMenuActivity;
import com.androidprimary.net.tcp.TcpActivity;
import com.androidprimary.net.udp.android.UdpActivity;
import com.androidprimary.service.ServiceActivity;
import com.androidprimary.viewpager.TabViewPagerActivity;
import com.androidprimary.viewpager.ViewPagerActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class aClass = SceneActivity.class;

        startActivity(new Intent(this, aClass));
    }
}