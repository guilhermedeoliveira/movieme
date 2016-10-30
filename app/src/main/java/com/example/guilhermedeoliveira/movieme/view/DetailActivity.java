package com.example.guilhermedeoliveira.movieme.view;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.model.Movie;

public class DetailActivity extends AppCompatActivity {

    /**
     * SHOW IN DETAIL Activity
     * título original
     * miniatura da imagem do cartaz do filme
     * uma sinopse da trama (chamada de visão geral na api)
     * avaliação do usuário (chamada vote_average na api)
     * data de lançamento
     */

    TextView mTitle;
    TextView mDescription;
    TextView mRelease;
    TextView mRating;
    ImageView mPoster;
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set title

        // Movie movie = intent.getExtras().getParcelable("movie");

        Intent intent = getIntent();
        if (intent != null) {

            mTitle = (TextView) findViewById(R.id.detail_title);
            mTitle.setText(intent.getStringExtra("title"));

            mDescription = (TextView) findViewById(R.id.detail_synopsis);
            mDescription.setText(intent.getStringExtra("synopsis"));

            mRelease = (TextView) findViewById(R.id.detail_release);
            mRelease.setText(intent.getStringExtra("release_date"));

            mRating = (TextView) findViewById(R.id.detail_rating);
            mRating.setText(intent.getStringExtra("rating"));

            mPoster = (ImageView) findViewById(R.id.detail_poster);
            //mPoster.setImageResource(intent.getE("poster"));
            mPoster.setImageResource(intent.getIntExtra("poster",0));

            collapsingToolbar= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
            collapsingToolbar.setTitle(intent.getStringExtra("title"));

            //String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);



        }
    }
}
