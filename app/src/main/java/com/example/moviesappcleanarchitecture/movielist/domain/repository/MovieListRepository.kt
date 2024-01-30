package com.example.moviesappcleanarchitecture.movielist.domain.repository

import com.example.moviesappcleanarchitecture.movielist.domain.model.Movie
import com.example.moviesappcleanarchitecture.movielist.util.Resource

import kotlinx.coroutines.flow.Flow


interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>
}