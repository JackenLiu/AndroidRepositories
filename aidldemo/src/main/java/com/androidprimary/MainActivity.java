package com.androidprimary;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "com.aidlserver";
    public static final String PACKAGE_NAME = "com.androidprimary";
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IMyAidlInterface imai = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                imai.showProgress();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operate(View v) {
        switch (v.getId()) {
            case R.id.start:
                //远程启动服务
                Intent it = new Intent();
                it.setAction(ACTION);
                it.setPackage(PACKAGE_NAME);
                startService(it);
                break;
            case R.id.stop:
                Intent it2 = new Intent();
                it2.setAction(ACTION);
                it2.setPackage(PACKAGE_NAME);
                stopService(it2);
                break;
            case R.id.bind:
                Intent it3 = new Intent();
                it3.setAction(ACTION);
                it3.setPackage(PACKAGE_NAME);
                bindService(it3, conn, BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                break;

        }
    }
}
