package com.example.guilhermedeoliveira.movieme.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guilhermedeoliveira.movieme.BuildConfig;
import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.adapter.MovieAdapter;
import com.example.guilhermedeoliveira.movieme.api.ApiService;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.model.MovieSchema;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by guilhermeoliveira on 14/10/16.
 */

public class MainFragment extends Fragment {

    public static final String TAG = MainFragment.class.getSimpleName();
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String THE_MOVIE_DATABASE_API_KEY = "Protected_key";

    private List<Movie> movies;
    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // RecyclerView
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        /*SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sortKey = prefs.getString("sortkey", "");
        String key = getQuery(sortKey); */

        Call<MovieSchema> call = apiService.getPopularMovies(THE_MOVIE_DATABASE_API_KEY);
        //Call<MovieSchema> call = apiService.getPopularMovies(BuildConfig.THE_MOVIE_DATABASE_API_KEY);
        call.enqueue(new Callback<MovieSchema>() {
            @Override
            public void onResponse(Call<MovieSchema> call, Response<MovieSchema> response) {
                if (response.isSuccessful()) {
                    movies = response.body().getListMovie();
                    mRecyclerView.setAdapter(new MovieAdapter(getActivity(), movies));
                } else {
                    Log.i(TAG, "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MovieSchema> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
        return rootView;
    }
}