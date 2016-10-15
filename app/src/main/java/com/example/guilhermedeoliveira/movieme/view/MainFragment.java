package com.example.guilhermedeoliveira.movieme.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guilhermedeoliveira.movieme.R;

/**
 * Created by guilhermeoliveira on 14/10/16.
 */

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        // View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
