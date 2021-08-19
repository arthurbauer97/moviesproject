package com.example.moviesproject.data

import com.example.moviesproject.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val dataSource: MoviesDataSource
) {

    suspend fun getMovies(): List<Movie> = dataSource.getPopularMovies().results
}