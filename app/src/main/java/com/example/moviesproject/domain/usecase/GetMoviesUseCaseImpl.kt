package com.example.moviesproject.domain.usecase

import com.example.moviesproject.data.MoviesRepository
import com.example.moviesproject.domain.model.Genre
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

    override suspend fun getMoviesUpcoming(): List<Movie> {
        return try {
            repository.getMoviesUpcoming()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMoviesTopRated(): List<Movie> {
        return try {
            repository.getMoviesTopRated()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getGenres(): List<Genre> {
        return try {
            repository.getGenres()
        } catch (e: Exception) {
            throw e
        }
    }
}