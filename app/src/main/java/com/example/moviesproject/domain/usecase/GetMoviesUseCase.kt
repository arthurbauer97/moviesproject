package com.example.moviesproject.domain.usecase

import com.example.moviesproject.domain.model.Movie

interface GetMoviesUseCase {

    suspend fun getMovies (): List<Movie>

}