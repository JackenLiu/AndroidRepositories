package com.androidprimary.ui.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidprimary.R;

public class ContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        // 控件旁弹出
        registerForContextMenu(findViewById(R.id.ctx_btn));

        // 上下文弹出
        findViewById(R.id.ctx_btn1).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActionMode(cb);
                return false;
            }
        });
    }

    // 上下文弹出
    ActionMode.Callback cb=new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // 点击前调用
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.delect) {
                Toast.makeText(ContextMenuActivity.this, "delect", Toast.LENGTH_LONG).show();
            } else if (item.getItemId() == R.id.item1) {
                Toast.makeText(ContextMenuActivity.this, "item1", Toast.LENGTH_LONG).show();
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // 关闭调用
        }
    };


    // 控件旁弹出
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
    }

    // 控件旁弹出
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delect) {
            Toast.makeText(this, "delect", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.item1) {
            Toast.makeText(this, "item1", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}