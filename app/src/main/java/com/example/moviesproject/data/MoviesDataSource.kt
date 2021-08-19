package com.example.moviesproject.data

import com.example.moviesproject.domain.model.ListMovieResponse
import com.example.moviesproject.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDataSource {
    @GET("movie/popular")
    suspend fun getPopularMovies(
//        @Query("api_key") api_key : Int,
//        @Query("language") offset : Int,
//        @Query("page") limit : Int
    ): ListMovieResponse
}