package com.example.moviesappcleanarchitecture.di

import com.example.moviesappcleanarchitecture.movielist.data.repository.MovieListRepositoryImpl
import com.example.moviesappcleanarchitecture.movielist.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl
    ):MovieListRepository
}