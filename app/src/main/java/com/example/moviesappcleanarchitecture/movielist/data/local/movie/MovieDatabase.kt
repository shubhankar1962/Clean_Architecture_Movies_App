package com.example.moviesappcleanarchitecture.movielist.data.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesappcleanarchitecture.movielist.data.local.movie.MovieDao
import com.example.moviesappcleanarchitecture.movielist.data.local.movie.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao : MovieDao
}