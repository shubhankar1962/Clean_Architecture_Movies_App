package com.example.moviesappcleanarchitecture.movielist.data.local.movie

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert


@Dao
interface MovieDao {

    @Upsert
    suspend fun upsertMovieList(movieList : List<MovieEntity>)

    @Query("Select * from movieEntity where id = :id")
    suspend fun getMovieById(id : Int): MovieEntity

    @Query("Select * from movieEntity where category = :category")
    suspend fun getMovieByCategory(category: String): List<MovieEntity>
}