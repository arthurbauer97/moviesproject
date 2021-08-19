package com.example.moviesproject.ui.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesproject.R
import com.example.moviesproject.domain.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(
    var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = movies[position]

        viewHolder.nameMovie.text = movie.title
        //viewHolder.timeMovie.text = movie
        //viewHolder.minAgeMovie.text = movie.minAge
        // viewHolder.genderMovie.text = movie.gender
        viewHolder.reviewMovie.text = movie.vote_count.toString()

        var movieUrl = "https://themoviedb.org/t/p/w300_and_h450_bestv2/" + movie.poster_path
        Glide.with(context).load(movieUrl).into(viewHolder.imageMovie);
    }

    override fun getItemCount() = movies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameMovie = itemView.tv_name_movie
        val timeMovie = itemView.tv_time_movie
        val minAgeMovie = itemView.tv_age_movie
        val imageMovie = itemView.iv_movie
        val genderMovie = itemView.tv_gender_movie
        val reviewMovie = itemView.tv_reviews_movie
    }
}