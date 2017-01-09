package com.example.guilhermedeoliveira.movieme.api;

import com.example.guilhermedeoliveira.movieme.model.MovieSchema;
import com.example.guilhermedeoliveira.movieme.model.ReviewSchema;
import com.example.guilhermedeoliveira.movieme.model.VideoSchema;
import com.example.guilhermedeoliveira.movieme.utils.Constants;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by guilhermedeoliveira on 09/01/17.
 */

public class Api {

    private static ApiService apiService;

    public static ApiService getClient() {
        if (apiService == null) {

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = client.create(ApiService.class);
        }
        return apiService;
    }

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
}
