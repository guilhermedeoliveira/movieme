package com.example.guilhermedeoliveira.movieme.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.data.MovieContract;
import com.example.guilhermedeoliveira.movieme.utils.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by guilhermedeoliveira on 08/01/17.
 */

public class MovieGridAdapter extends CursorAdapter {

    private static final String LOG_TAG = MovieGridAdapter.class.getSimpleName();

    public MovieGridAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.mContext = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movie, parent, false);
        return view;
    }

    /*
        This is where we fill-in the views with the contents of the cursor.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView poster = (ImageView) view.findViewById(R.id.movie_poster);

        //Picasso.with(mContext).invalidate(Constants.MOVIE_DB_POSTER_URL + Constants.POSTER_PHONE_SIZE + convertCursorRowToUXFormat(cursor));
        Log.d(LOG_TAG, "Loading image... for movie ID: " + cursor.getInt(0) + " movie title: " + cursor.getString(1) + " poster path: " + cursor.getString(2));

        Picasso.with(context)
                .load(Constants.IMAGE_BASE_URL + convertCursorRowToUXFormat(cursor))
                .placeholder(R.drawable.placeholder) // support download placeholder
                //.error(R.drawable.poster_placeholder_error) //support error placeholder, if back-end returns empty string or null
                .into(poster);
    }

    /**
     * This method returns Poster URL (string) from the passed cursor.
     */
    private String convertCursorRowToUXFormat(Cursor cursor) {
        // get row indices for our cursor
        int poster = cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_POSTER);
        Log.d(LOG_TAG, "Column Index: " + poster);
        return cursor.getString(poster);
    }
}
