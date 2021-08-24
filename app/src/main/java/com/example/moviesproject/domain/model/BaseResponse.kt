package com.example.moviesproject.domain.model

data class BaseResponse<T>(
    var page : Int,
    var results : List<T>,
)