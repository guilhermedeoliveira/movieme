package com.example.guilhermedeoliveira.movieme.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guilhermeoliveira on 20/10/16.
 */

public class MovieSchema {

    @SerializedName("page")
    private int mPage;

    @SerializedName("results")
    private List<Movie> mListMovie;

    @SerializedName("total_results")
    private int mTotalMovies;

    @SerializedName("total_pages")
    private int mTotalPages;

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        this.mPage = page;
    }

    public List<Movie> getListMovie() {
        return mListMovie;
    }

    public int getTotalMovies() {
        return mTotalMovies;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

}

