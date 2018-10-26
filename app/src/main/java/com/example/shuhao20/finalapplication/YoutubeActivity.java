package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class YoutubeActivity extends YouTubeBaseActivity {
    private YouTubePlayerView mYv;
    private Button mBtn;
    private YouTubePlayer.OnInitializedListener mOnInitializedListner;
    private ImageView mIv;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        Log.d(TAG, "onCreate: Starting");

        mYv = findViewById(R.id.yv);
        mBtn = findViewById(R.id.btn);
//        mIv = findViewById(R.id.iv);
//
//        mIv.setImageResource(R.mipmap.smalltoplogo);

        mOnInitializedListner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Initializing YouTUBE Player.");
                youTubePlayer.loadVideo("8w2Fm3I7JUg");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to initialize");
            }
        };

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Initializing YouTUBE Player.");
                mYv.initialize(YoutubeConfig.getApiKey(), mOnInitializedListner);
            }
        });



    }
}
