package com.example.guilhermedeoliveira.movieme.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class ReviewSchema {

    @SerializedName("results")
    private List<Review> mListReview;

    public List<Review> getListReview() {
        return mListReview;
    }
}
