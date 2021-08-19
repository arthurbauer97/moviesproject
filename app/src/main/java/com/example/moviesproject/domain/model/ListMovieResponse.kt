package com.example.moviesproject.domain.model

data class ListMovieResponse(
    var page : Int,
    var results : List<Movie>,
)