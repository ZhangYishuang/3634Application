package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
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

public class SelectActivity extends AppCompatActivity {
    private ImageView mIv;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        mIv = findViewById(R.id.iv);
        mRv = findViewById(R.id.rv);

        mIv.setImageResource(R.mipmap.smalltoplogo);



        //Material Design
        mRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRv.addItemDecoration(new SelectActivity.MyDecoration());
        mRv.setAdapter(new StaggeredGridAdapter(SelectActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(SelectActivity.this, QuizActivity.class);
                intent.putExtra("pos", pos);
                intent.putExtra("quizNum",0);
                startActivity(intent);
            }
        }, 2));


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
