package com.example.guilhermedeoliveira.movieme.data;

import android.provider.BaseColumns;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class MovieContract {

    public static final class MovieEntry implements BaseColumns {

        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_POSTER = "poster";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_SYNOPSIS = "synopsis";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_FAVORITE = "favorite";

    }

    public static final class ReviewEntry implements BaseColumns {

        public static final String TABLE_NAME = "review";

        public static final String COLUMN_REVIEW_ID = "review_id";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_URL = "url";
    }

    public static final class VideoEntry implements BaseColumns {

        public static final String TABLE_NAME = "video";

        public static final String COLUMN_VIDEO_ID = "video_id";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_YOUTUBE_KEY = "youtube_key";
        public static final String COLUMN_TITLE_VIDEO = "name";

    }
}
