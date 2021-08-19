package com.example.moviesproject.domain.usecase

import com.example.moviesproject.data.MoviesRepository
import com.example.moviesproject.domain.model.Movie

class GetMoviesUseCaseImpl(
    private val repository: MoviesRepository
) : GetMoviesUseCase {

    override suspend fun getMovies(): List<Movie> {
        return try {
            repository.getMovies()
        } catch (e: Exception) {
            throw e
        }
    }
}