package com.example.guilhermedeoliveira.movieme.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class Review {

    @SerializedName("id")
    private int mId;

    @SerializedName("author")
    private String mAuthor;

    @SerializedName("content")
    private String mContent;

    @SerializedName("url")
    private String mUrl;

    public int getId() {
        return mId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getContent() {
        return mContent;
    }

    public String getUrl() {
        return mUrl;
    }
}