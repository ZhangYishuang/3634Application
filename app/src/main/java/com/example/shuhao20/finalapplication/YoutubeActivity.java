package com.example.shuhao20.finalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shuhao20.finalapplication.Adapter.VideoAdapter;

import java.util.Vector;

//public class YoutubeActivity extends YouTubeBaseActivity {
//    private YouTubePlayerView mYv;
//    private Button mBtn;
//    private YouTubePlayer.OnInitializedListener mOnInitializedListner;
//    private ImageView mIv;
//
//    private static final String TAG = "MainActivity";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_youtube);
//
//        Log.d(TAG, "onCreate: Starting");
//
//        mYv = findViewById(R.id.yv);
//        mBtn = findViewById(R.id.btn);
////        mIv = findViewById(R.id.iv);
////
////        mIv.setImageResource(R.mipmap.smalltoplogo);
//
//        mOnInitializedListner = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                Log.d(TAG, "onClick: Initializing YouTUBE Player.");
//                youTubePlayer.loadVideo("8w2Fm3I7JUg");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                Log.d(TAG, "onClick: Failed to initialize");
//            }
//        };
//
//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: Initializing YouTUBE Player.");
//                mYv.initialize(YoutubeConfig.getApiKey(), mOnInitializedListner);
//            }
//        });
//
//
//
//    }
//}


public class YoutubeActivity extends AppCompatActivity {

    //recycler view field
    RecyclerView recyclerView;

    //vector for video urls
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();

    VideoAdapter videoAdapter;
//            ProductAdapter adapter;
//            List<Text> productList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //load video list
        //    textContent();
        videoContent();

        // adapter = new ProductAdapter(this,productList);

        videoAdapter = new VideoAdapter(youtubeVideos);


        recyclerView.setAdapter(videoAdapter);
        // recyclerView.setAdapter(adapter);
    }

    private void videoContent() {
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NcmDpIFVJN4\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bxIZ1GVWYkQ\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hF8F3wm9DUc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RnD6NJs5xoI\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eNPX2pTiaHI\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-oi9Pg0128M\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-IJ5izjbWIA\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RxeDe6BsTMI\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jM8gOF6Oi-U\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zZq_XDhU-rc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));


    }

    private void textContent() {
    }
}
