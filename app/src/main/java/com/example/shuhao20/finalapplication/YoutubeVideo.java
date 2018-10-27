package com.example.shuhao20.finalapplication;

public class YoutubeVideo {

    String VideoUrl;

    public YoutubeVideo(){

    }

    public YoutubeVideo(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }
}
