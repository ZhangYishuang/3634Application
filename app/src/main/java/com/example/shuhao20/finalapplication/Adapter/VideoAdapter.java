package com.example.shuhao20.finalapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.shuhao20.finalapplication.YoutubeVideo;
import com.example.shuhao20.finalapplication.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YoutubeVideo> youtubeVideoList;

    public VideoAdapter() {
    }

    public VideoAdapter(List<YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_video, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {

        videoViewHolder.videoWeb.loadData(youtubeVideoList.get(i).getVideoUrl(), "text/html", "utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView videoWeb;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.webView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {


            });
        }
    }
}
