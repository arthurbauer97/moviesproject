package com.example.moviesproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

        viewHolder.nameMovie.text = movie.name
        viewHolder.timeMovie.text = movie.time
        viewHolder.minAgeMovie.text = movie.minAge
        viewHolder.genderMovie.text = movie.gender
        viewHolder.reviewMovie.text = movie.reviews
        viewHolder.imageMovie.setImageDrawable(movie.image)
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