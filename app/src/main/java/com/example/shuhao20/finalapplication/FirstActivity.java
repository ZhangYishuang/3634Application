package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shuhao20.finalapplication.Adapter.StaggeredGridAdapter;

public class FirstActivity extends AppCompatActivity {
    private ImageView mIv;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mRv = findViewById(R.id.rv);
        mIv = findViewById(R.id.iv);
        mIv.setImageResource(R.mipmap.smalltoplogo);

        mRv.setLayoutManager(new GridLayoutManager(FirstActivity.this, 2));
        mRv.addItemDecoration(new MyDecoration());
        mRv.setAdapter(new StaggeredGridAdapter(FirstActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                if (pos == 0) {
                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (pos == 1) {
                    Intent intent = new Intent(FirstActivity.this, YoutubeList.class);
                    startActivity(intent);
                } else if (pos == 2) {
                    Intent intent = new Intent(FirstActivity.this, SelectActivity.class);
                    startActivity(intent);
                } else if (pos == 3) {
                    Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, 0));

        setFullScreenWithStatusBar(FirstActivity.this);
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        //set gaps
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.divider);
            outRect.set(gap, gap, gap, gap);
        }
    }

    //Up layout and get status bar transparent
    public static void setFullScreenWithStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Set status bar transparent
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Root layout up
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            ViewCompat.setFitsSystemWindows(rootView, false);
            rootView.setClipToPadding(true);
        }
    }




}
