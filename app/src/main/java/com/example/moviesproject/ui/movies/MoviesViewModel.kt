package com.example.moviesproject.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.Movie
import com.example.moviesproject.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class MoviesViewModel (
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : MutableLiveData<List<Movie>> = _movies

    private val _genres = MutableLiveData<List<Genre>>()
    val genres : MutableLiveData<List<Genre>> = _genres

    private var isFormValid = false

    fun getMovies() = viewModelScope.launch {

        isFormValid = true

        if (isFormValid) {
            try {
                val movies = getMoviesUseCase.getMovies()
                _movies.value = movies
            } catch (e: Exception) {
                Log.e("viewModel", e.toString())
            }
        }
    }

    fun getGeneres() = viewModelScope.launch {

        isFormValid = true

        if (isFormValid) {
            try {
                val genres = getMoviesUseCase.getGenres()
                _genres.value = genres
            } catch (e: Exception) {
                Log.e("viewModel", e.toString())
            }
        }
    }

}