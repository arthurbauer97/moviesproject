package com.example.moviesproject.domain.model

data class Genre(
    var id : Int,
    var name : String = ""
)

data class GenreResponse(
    val genres: List<Genre>
)