package com.example.guilhermedeoliveira.movieme.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class VideoSchema {

    @SerializedName("results")
    private List<Video> mListVideo;

    public List<Video> getListTrailer() {
        return mListVideo;
    }
}
