package com.example.moviesproject.domain.usecase

import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.Movie

interface GetMoviesUseCase {

    suspend fun getMovies (): List<Movie>

    suspend fun getGenres (): List<Genre>

}