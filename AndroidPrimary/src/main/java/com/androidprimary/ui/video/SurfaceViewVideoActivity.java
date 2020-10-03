package com.androidprimary.ui.video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;

import com.androidprimary.R;

import java.io.IOException;

public class SurfaceViewVideoActivity extends AppCompatActivity {

    private String url = "https://v-cdn.zjol.com.cn/276990.mp4";
//    private String url = "https://media.w3.org/2010/05/sintel/trailer.mp4";
    private SurfaceHolder holder;
    private MediaPlayer player;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_video);

        SurfaceView surfaceView = findViewById(R.id.sv);
        progressBar = findViewById(R.id.progressBar);
        holder = surfaceView.getHolder();

    }


    public void prepare(View view) {
        progressBar.setVisibility(View.VISIBLE);

        player = new MediaPlayer();
        try {
            player.setDataSource(this, Uri.parse(url));
            // 联网，异步准备
            player.prepareAsync();
            player.setDisplay(holder);
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    progressBar.setVisibility(View.GONE);

                }
            });

            // 缓冲进度
            player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    if (mp.isLooping()) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.GONE);
                    }
                    Log.d("onBufferingUpdate", percent + "");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(View view) {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            } else {
                player.start();
            }
        }
    }
}