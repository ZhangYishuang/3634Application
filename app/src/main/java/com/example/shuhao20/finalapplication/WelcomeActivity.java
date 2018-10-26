package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {
    private ImageView mIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //full screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mIv = findViewById(R.id.iv);
        mIv.setImageResource(R.mipmap.welcomelogo);
        startMainActivity();
        hideBottomUIMenu();
    }

    private void startMainActivity(){

        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(WelcomeActivity.this,FirstActivity.class);
                startActivity(mainIntent);
                WelcomeActivity.this.finish();
            }
        };
        Timer timer = new Timer();
        //Set time delay for 2s
        timer.schedule(delayTask,2000);
    }

    //Hide bottom bar
    protected void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
