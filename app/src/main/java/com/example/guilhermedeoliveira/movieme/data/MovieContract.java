package com.example.guilhermedeoliveira.movieme.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by guilhermedeoliveira on 03/11/16.
 */

public class MovieContract {

    // The name of unique content provider (Authority)
    public static final String CONTENT_AUTHORITY = "com.example.guilhermedeoliveira.movieme";
    // Create the base URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    // Path to access tables
    public static final String PATH_MOVIE = "movie";
    public static final String PATH_REVIEW = "review";
    public static final String PATH_VIDEO = "video";

    public static final class MovieEntry implements BaseColumns {

        // Content URI for table MovieEntry
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;

        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_POSTER = "poster";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_SYNOPSIS = "synopsis";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_FAVORITE = "favorite";

        /**
         * This method creates a URI for addressing a movie according to its poster URL
         *
         * @param posterUrl The stringly-typed URL fetched from the cloud service
         * @return The URI with the given {@code posterUrl} appended
         */
        public static Uri buildMovieWithPoster(String posterUrl) {
            return CONTENT_URI.buildUpon()
                    .appendPath(posterUrl.substring(1)) //remove the heading slash
                    .build();
        }

        /**
         * Build a Uri for a record of the table, using the ID
         *
         * @param id The ID of the record
         * @return A new Uri with the given ID appended to the end of the path
         */
        public static Uri buildMovieWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * This method does the opposite of {@code buildMovieWithPoster}, hence returns the
         * stringly-typed URL
         *
         * @param uri The URI of the movie
         * @return The poster URL fetched from the URI
         */
        public static String getPosterUrlFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        /**
         * Parse the ID of a record, or return -1 instead
         *
         * @param uri The Uri of the record
         * @return The Id of the record or -1 if this doesn't apply
         */
        public static long getIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }

    }

    public static final class ReviewEntry implements BaseColumns {

        // Content URI for table ReviewEntry
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_REVIEW).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REVIEW;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REVIEW;

        public static final String TABLE_NAME = "review";

        public static final String COLUMN_REVIEW_ID = "review_id";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_URL = "url";

        /**
         * Get the movie ID in the URI (the ID from the Backend)
         *
         * @param uri The Uri of the review with the movie id appended
         * @return The ID of the movie, or -1 if doesn't exist
         */
        public static long getMovieIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }

        /**
         * Creates a trailer uri with the movie id (from the backend) appended
         *
         * @param insertedId The ID of the movie
         * @return The uri of the review
         */
        public static Uri buildVideoWithId(long insertedId) {
            return ContentUris.withAppendedId(CONTENT_URI, insertedId);
        }

    }

    public static final class VideoEntry implements BaseColumns {

        // Content URI for table VideoEntry
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_VIDEO).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VIDEO;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VIDEO;

        public static final String TABLE_NAME = "video";

        public static final String COLUMN_VIDEO_ID = "video_id";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_YOUTUBE_KEY = "youtube_key";
        public static final String COLUMN_TITLE_VIDEO = "name";

        /**
         * Get the movie ID in the URI (the ID from the Backend)
         *
         * @param uri The trailer's URI with the movie ID
         * @return The movie ID or -1 if doesn't exist
         */
        public static long getMovieIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }

        /**
         * Creates a trailer uri with the movie id (from the backend) appended
         *
         * @param movieId The movie ID
         * @return the URI of the trailer
         */
        public static Uri buildVideoWithId(long movieId) {
            return ContentUris.withAppendedId(CONTENT_URI, movieId);
        }

    }
}
