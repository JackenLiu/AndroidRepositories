package com.androidprimary.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.androidprimary.R;
import com.androidprimary.dialog.dialog.MyDialog;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setTitle("标题");
                builder.setMessage("提升内容");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });


        findViewById(R.id.custom_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyDialog(AlertDialogActivity.this, R.style.my_dialog).show();
            }
        });

        findViewById(R.id.custom_array_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] strings = {"ada", "ssssss", "a", "osfodwf", "vvvvvv", "mmmmmmmmmmm", "ooooo"};

//                ArrayAdapter adapter = new ArrayAdapter(AlertDialogActivity.this,
//                        android.R.layout.simple_dropdown_item_1line, strings);
                ArrayAdapter adapter = new ArrayAdapter(AlertDialogActivity.this,
                        R.layout.array_item_layout, R.id.tv, strings);
                AlertDialog.Builder builder = new AlertDialog.
                        Builder(AlertDialogActivity.this)
                        .setTitle("请选择")
                        .setAdapter(adapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertDialogActivity.this, strings[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
            }
        });
    }
}