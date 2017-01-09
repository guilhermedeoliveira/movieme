package com.example.guilhermedeoliveira.movieme.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.guilhermedeoliveira.movieme.R;

/**
 * Created by guilhermedeoliveira on 27/12/16.
 */

public class Utility {
    public static String getPreferredSortOrder(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        return prefs.getString(
                context.getString(R.string.sort_by_key),
                context.getString(R.string.pref_sort_popular));
    }

}
