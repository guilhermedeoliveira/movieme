package com.example.guilhermedeoliveira.movieme.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class Video {

    @SerializedName("id")
    private String mId;

    @SerializedName("key")
    private String mKey;

    @SerializedName("name")
    private String mTitleVideo;

    @SerializedName("site")
    private String mSite;

    public String getId() {
        return mId;
    }

    public String getKey() {
        return mKey;
    }

    public String getTitleVideo() {
        return mTitleVideo;
    }

    public String getSite() {
        return mSite;
    }
}
