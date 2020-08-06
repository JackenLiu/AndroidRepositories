package com.androidprimary.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.androidprimary.R;

public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        final Button btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(PopupWindowActivity.this).
                        inflate(R.layout.popup_layout, null);
                final PopupWindow window = new PopupWindow(view,
                        600, 120, true);

                // 更改背景
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                window.setOutsideTouchable(true);
                window.setTouchable(true);

                // 动画
                window.setAnimationStyle(R.style.translate_anim);

                window.showAsDropDown(btn, 10, 10);

                // 点击监听
                view.findViewById(R.id.tv_copy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PopupWindowActivity.this, "复制", Toast.LENGTH_SHORT).show();
                        window.dismiss();
                    }
                });

            }
        });
    }
}