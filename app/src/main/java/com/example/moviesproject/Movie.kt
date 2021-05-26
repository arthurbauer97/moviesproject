package com.example.moviesproject

import android.graphics.drawable.Drawable

data class Movie(
    var name : String = "",
    var time : String = "",
    var minAge : String = "0",
    var image : Drawable?,
    var reviews : String = "",
    var gender : String = ""
)