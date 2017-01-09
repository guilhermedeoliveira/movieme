package com.example.guilhermedeoliveira.movieme.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.adapter.BaseGridAdapter;
import com.example.guilhermedeoliveira.movieme.adapter.MovieGridAdapter;
import com.example.guilhermedeoliveira.movieme.api.Api;
import com.example.guilhermedeoliveira.movieme.api.ApiService;
import com.example.guilhermedeoliveira.movieme.data.MovieContract;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.model.MovieSchema;
import com.example.guilhermedeoliveira.movieme.utils.Constants;
import com.example.guilhermedeoliveira.movieme.utils.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by guilhermedeoliveira on 08/01/17.
 */

public class MainGridFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String TAG = MainGridFragment.class.getSimpleName();
    private static final int MOVIE_LOADER = 0;

    private List<Movie> movies;
    GridView mGridView;
    MovieGridAdapter mMovieGridAdapter;


    private static final String[] MOVIE_COLUMNS = {
            MovieContract.MovieEntry.TABLE_NAME + "." + MovieContract.MovieEntry._ID,
            //MovieContract.MovieEntry.COLUMN_TITLE,
            MovieContract.MovieEntry.COLUMN_POSTER
    };

    // these constants correspond to the projection defined above, and must change if the
    // projection changes
    private static final int COL_MOVIE_ID = 0;
    //private static final int COL_MOVIE_TITLE = 1;
    private static final int COL_MOVIE_POSTER = 1;

    public MainGridFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grid_main, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.grid_view);
        mMovieGridAdapter = new MovieGridAdapter(getActivity(), null, 0);
        mGridView.setAdapter(mMovieGridAdapter);

        // Handle Click
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Cursor data = (Cursor) adapterView.getItemAtPosition(position);
                if (data != null) {
                    Intent detailsIntent = new Intent(getActivity(), DetailActivity.class);
                    //final int MOVIE_ID_COL = data.getColumnIndex(MovieContract.MovieEntry._ID);
                    Uri movieUri = MovieContract.MovieEntry.buildMovieWithId(data.getInt(COL_MOVIE_ID));

                    detailsIntent.setData(movieUri);
                    startActivity(detailsIntent);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(MOVIE_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    void onTypeChanged() {
        updateMovie();
        getLoaderManager().restartLoader(MOVIE_LOADER, null, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateMovie();
    }

    private void updateMovie() {

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
                            mGridView.setAdapter(new BaseGridAdapter(getActivity(), movies));
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
                            mGridView.setAdapter(new MovieGridAdapter(getActivity(), null, 0));
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
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String sortOrderSetting = Utility.getPreferredSortOrder(getActivity());
        String sortOrder;
        final int NUMBER_OF_MOVIES = 20;

        sortOrder = MovieContract.MovieEntry.COLUMN_RATING + " DESC";

        return new CursorLoader(getActivity(),
                MovieContract.MovieEntry.CONTENT_URI,
                MOVIE_COLUMNS,
                null,
                null,
                sortOrder + " LIMIT " + NUMBER_OF_MOVIES);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mMovieGridAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mMovieGridAdapter.swapCursor(null);
    }
}