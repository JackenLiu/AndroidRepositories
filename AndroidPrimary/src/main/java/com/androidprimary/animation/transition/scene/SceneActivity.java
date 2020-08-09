package com.androidprimary.animation.transition.scene;

import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.androidprimary.R;

public class SceneActivity extends AppCompatActivity {

    private Scene mOverViewScene;
    private Scene mInfoScene;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        mOverViewScene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_overview, getBaseContext());
        mInfoScene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_info, getBaseContext());

        TransitionManager.go(mOverViewScene);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInfo:
                Transition transition = TransitionInflater.from(getBaseContext())
                        .inflateTransition(R.transition.transition);
                TransitionManager.go(mInfoScene, transition);
                break;
            case R.id.btnClose:
                TransitionManager.go(mOverViewScene);
                break;
        }
    }

}
