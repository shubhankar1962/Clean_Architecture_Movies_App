package com.example.moviesappcleanarchitecture.details.presnation

import com.example.moviesappcleanarchitecture.movielist.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)