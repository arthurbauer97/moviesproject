package com.example.moviesproject.domain.model

data class Movie(
    var adult : Boolean = false,
    var vote_count : Int,
    var title : String = "",
    var poster_path : String = ""
)