package com.example.guilhermedeoliveira.movieme.api;

import com.example.guilhermedeoliveira.movieme.BuildConfig;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.model.MovieSchema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by guilhermeoliveira on 15/10/16.
 */

public interface ApiService {

    @GET("movie/popular")
    Call<MovieSchema> getPopularMovies(@Query("api_key") String API_KEY);

    @GET ("movie/top_rated")
    Call<List<Movie>> getTopRatedMovies(@Query("api_key") String API_KEY);
}
