package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.shuhao20.finalapplication.Adapter.StaggeredGridAdapter;
import com.githang.statusbar.StatusBarCompat;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvWaterfall;
    private FloatingActionButton mFab;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvWaterfall = findViewById(R.id.rv_waterfall);
        mFab = findViewById(R.id.fab);
        mIv = findViewById(R.id.iv);

        mIv.setImageResource(R.mipmap.smalltoplogo);

        //Material Design
        mRvWaterfall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvWaterfall.addItemDecoration(new MyDecoration());
        mRvWaterfall.setAdapter(new StaggeredGridAdapter(MainActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(MainActivity.this, ChapterLearning.class);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        }, 1));
        //Set OnClickListener for FloatingActionButton
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChapterLearning.class);
                intent.putExtra("pos", 16);
                startActivity(intent);
            }
        });

        setFullScreenWithStatusBar(this);

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
