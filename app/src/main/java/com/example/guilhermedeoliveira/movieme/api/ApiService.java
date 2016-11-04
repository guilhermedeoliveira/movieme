package com.example.guilhermedeoliveira.movieme.api;

import com.example.guilhermedeoliveira.movieme.model.MovieSchema;
import com.example.guilhermedeoliveira.movieme.model.ReviewSchema;
import com.example.guilhermedeoliveira.movieme.model.VideoSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by guilhermeoliveira on 15/10/16.
 */

public interface ApiService {

    @GET("movie/popular")
    Call<MovieSchema> getPopularMovies(@Query("api_key") String API_KEY);

    @GET ("movie/top_rated")
    Call<MovieSchema> getTopRatedMovies(@Query("api_key") String API_KEY);

    @GET ("movie/{movie_id}/reviews")
    Call<ReviewSchema> getMovieReview(@Path("movie_id") int id, @Query("api_key") String API_KEY);

    @GET ("/movie/{movie_id}/videos")
    Call<VideoSchema> getMovieVideo(@Path("movie_id") int id, @Query("api_key") String API_KEY);
}