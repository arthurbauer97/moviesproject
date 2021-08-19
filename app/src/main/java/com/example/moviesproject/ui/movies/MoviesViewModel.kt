package com.example.moviesproject.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesproject.data.MoviesRepository
import com.example.moviesproject.domain.model.Movie
import com.example.moviesproject.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class MoviesViewModel (
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : MutableLiveData<List<Movie>> = _movies

    private var isFormValid = false

    fun getMovies() = viewModelScope.launch {

        isFormValid = true

        if (isFormValid) {
            try {
                val movies = getMoviesUseCase.getMovies()
                _movies.value = movies
            } catch (e: Exception) {
                Log.d("Get Movies", e.toString())
            }
        }
    }

}