package com.example.moviesproject.data

import com.example.moviesproject.domain.model.BaseResponse
import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.GenreResponse
import com.example.moviesproject.domain.model.Movie
import retrofit2.http.GET

interface MoviesDataService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
//        @Query("page") limit : Int
    ): BaseResponse<Movie>

    @GET("genre/movie/list")
    suspend fun getGenreMovies(
    ): GenreResponse
}