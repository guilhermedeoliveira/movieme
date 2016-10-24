package com.example.guilhermedeoliveira.movieme.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.guilhermedeoliveira.movieme.BuildConfig;
import com.example.guilhermedeoliveira.movieme.R;
import com.example.guilhermedeoliveira.movieme.adapter.MovieAdapter;
import com.example.guilhermedeoliveira.movieme.api.ApiService;
import com.example.guilhermedeoliveira.movieme.model.Movie;
import com.example.guilhermedeoliveira.movieme.model.MovieSchema;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.guilhermedeoliveira.movieme.view.MainFragment.BASE_URL;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment()).commit();
        }
    }
}