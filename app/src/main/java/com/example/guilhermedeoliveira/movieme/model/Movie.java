package com.example.guilhermedeoliveira.movieme.model;

import com.example.guilhermedeoliveira.movieme.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilhermeoliveira on 15/10/16.
 */

public class Movie {

    @SerializedName("original_title")
    private String mTitle;

    @SerializedName("id")
    private int mId;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("poster_path")
    private String mPoster;

    @SerializedName("backdrop_path")
    private String mBackdrop;

    @SerializedName("vote_average")
    private Double mRating;

    @SerializedName("vote_count")
    private int mVoteCount;

    @SerializedName("overview")
    private String mSynopsis;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds = new ArrayList<Integer>();

    public String getTitle() {
        return mTitle;
    }

    public int getId() {
        return mId;
    }

    @SerializedName("page")
    private int mPage;

    @SerializedName("total_pages")
    private int mTotalPages;

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getPoster() {
        return Constants.IMAGE_BASE_URL + mPoster;
    }

    public Double getRating() {
        return mRating;
    }

    public int getPage() {
        return mPage;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public double getPopularity() {
        return mPopularity;
    }
}
