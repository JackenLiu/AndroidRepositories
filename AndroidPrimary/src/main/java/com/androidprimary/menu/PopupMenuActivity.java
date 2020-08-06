package com.androidprimary.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.androidprimary.R;

public class PopupMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        findViewById(R.id.popup_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(PopupMenuActivity.this,
                        findViewById(R.id.popup_btn));

                menu.getMenuInflater().inflate(R.menu.popup, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.delect) {
                            Toast.makeText(PopupMenuActivity.this,
                                    "PopupMenu 的删除", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });
    }
}