package com.example.guilhermedeoliveira.movieme.view;

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
import android.widget.Toast;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.adapter.MovieAdapter;
import com.example.guilhermedeoliveira.movieme.api.Api;
import com.example.guilhermedeoliveira.movieme.api.ApiService;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.model.MovieSchema;
import com.example.guilhermedeoliveira.movieme.utils.Connectivity;
import com.example.guilhermedeoliveira.movieme.utils.Constants;

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

    private List<Movie> movies;
    private RecyclerView mRecyclerView;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        if (Connectivity.isOnline(getActivity())) {
            // RecyclerView
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        } else {
            Toast.makeText(getActivity(), "Please, check your Internet connection", Toast.LENGTH_SHORT).show();
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String sortByKey = prefs.getString(getString(R.string.sort_by_key),
                getString(R.string.pref_sort_popular));

        // Retrofit
        Api.ApiService apiService = Api.getClient();

        switch (sortByKey) {
            case Constants.POPULAR:
                Call<MovieSchema> callPop = apiService.getPopularMovies(Constants.THE_MOVIE_DATABASE_API_KEY);
                callPop.enqueue(new Callback<MovieSchema>() {
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
                break;
            case Constants.TOP_RATED:
                Call<MovieSchema> callTop = apiService.getTopRatedMovies(Constants.THE_MOVIE_DATABASE_API_KEY);
                callTop.enqueue(new Callback<MovieSchema>() {
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
        }
        return rootView;
    }
}