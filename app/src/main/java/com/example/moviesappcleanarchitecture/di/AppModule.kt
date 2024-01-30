package com.example.moviesappcleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.example.moviesappcleanarchitecture.movielist.data.local.movie.MovieDatabase
import com.example.moviesappcleanarchitecture.movielist.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


//----------------------------------this module is contain the dependencies for retrofit and room

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
        .build()

    @Singleton    //-----------------------singleton means creating only a single instance in all over the project
    @Provides         //-----------------------provide the dependency
    fun provideMovieApi(): MovieApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app:Application) : MovieDatabase{
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "moviedb.db"
        ).build()
    }
}