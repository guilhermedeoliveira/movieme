package com.example.guilhermedeoliveira.movieme.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by guilhermeoliveira on 17/10/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovieList;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            mPoster = (ImageView) itemView.findViewById(R.id.movie_poster);
        }
    }

    public MovieAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        this.mMovieList = movies;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mMovieList.get(position);
        Picasso.with(mContext).load(movie.getPoster()).placeholder(R.drawable.placeholder)
                .into(holder.mPoster);
        holder.mPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                intent.putExtra("title", movie.getTitle());
                intent.putExtra("synopsis", movie.getSynopsis());
                intent.putExtra("release_date", movie.getReleaseDate().substring(0, 4));
                intent.putExtra("rating", movie.getRating().toString());
                intent.putExtra("poster", movie.getPoster());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mMovieList != null ? this.mMovieList.size() : 0;
    }
}