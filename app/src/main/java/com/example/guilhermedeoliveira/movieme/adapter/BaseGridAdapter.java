package com.example.guilhermedeoliveira.movieme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by guilhermedeoliveira on 09/01/17.
 */

public class BaseGridAdapter extends BaseAdapter {
    private List<Movie> movies ;
    private Context mContext ;

    public BaseGridAdapter (Context context, List<Movie> movies) {
        super();
        this.mContext = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public long getItemId(int i) {
        return 0 ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.adapter_movie, viewGroup, false);
        ImageView poster = (ImageView) v.findViewById(R.id.movie_poster);
        Movie movie = movies.get(i);
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.drawable.placeholder) // support download placeholder
                //.error(R.drawable.poster_placeholder_error) //support error placeholder, if back-end returns empty string or null
                .into(poster);

        return v;
    }
}