package com.example.moviesproject.data

import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.Movie

class MoviesRepository(
    private val dataSource: MoviesDataService
) {

    suspend fun getMovies(): List<Movie> = dataSource.getPopularMovies().results

    suspend fun getGenres(): List<Genre> = dataSource.getGenreMovies().genres
}