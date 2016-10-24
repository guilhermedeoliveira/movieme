package com.example.guilhermedeoliveira.movieme.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guilhermedeoliveira.movieme.R;

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
        View viewRoot = inflater.inflate(R.layout.fragment_detail, container, false);
        return viewRoot;
    }
}
