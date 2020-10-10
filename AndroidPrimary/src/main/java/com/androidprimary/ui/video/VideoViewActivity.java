package com.androidprimary.ui.video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.androidprimary.R;

import java.io.IOException;

public class VideoViewActivity extends AppCompatActivity {

    //    private String url = "https://media.w3.org/2010/05/sintel/trailer.mp4";
    private String url = "https://v-cdn.zjol.com.cn/276990.mp4";

    private ProgressBar progressBar;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        progressBar = findViewById(R.id.progressBar);
        videoView = findViewById(R.id.vv);
    }

    public void prepare(View view) {
        progressBar.setVisibility(View.VISIBLE);

        videoView.setVideoURI(Uri.parse(url));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });

        videoView.setMediaController(new MediaController(this));
    }

    public void start(View view) {
        if (videoView != null) {
            if (videoView.isPlaying()) {
                videoView.pause();
            } else {
                videoView.start();
            }
        }
    }
}