package com.example.guilhermedeoliveira.movieme.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.model.Movie;

/**
 * Created by guilhermeoliveira on 15/10/16.
 */

public class DetailFragment extends Fragment {

    /**
     * SHOW IN DETAIL FRAGMENT
     * título original
     * miniatura da imagem do cartaz do filme
     * uma sinopse da trama (chamada de visão geral na api)
     * avaliação do usuário (chamada vote_average na api)
     * data de lançamento
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.mTitle))
                    .setText(forecastStr);
        }
        /*Intent movieIntent = getActivity().getIntent();
        Movie movie = movieIntent.getExtras().getParcelable("movie");

        TextView title = (TextView) viewRoot.findViewById(R.id.mTitle);
        title.setText(movie.getTitle()); */

            //ImageView movieView = (ImageView) viewRoot.findViewById(R.id.movie_poster);
            //movieView.showMovie(movie);

        /*
        TextView release = (TextView) rootView.findViewById(R.id.release);
        release.setText(movie.getReleaseDate().substring(0, 4));

        TextView vote = (TextView) rootView.findViewById(R.id.vote);
        vote.setText(movie.getVoteAverage() + "/10");

        TextView synopsis = (TextView) rootView.findViewById(R.id.synopsis);
        synopsis.setText(movie.getOverview()); */
            return rootView;
        }
    }
