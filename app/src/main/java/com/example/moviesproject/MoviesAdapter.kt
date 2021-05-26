package com.example.moviesproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(
    var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.VH>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        context = parent.context
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
      val movie = movies[position]

        holder.nameMovie.text = movie.name
        holder.timeMovie.text = movie.time
        holder.minAgeMovie.text = movie.minAge
        holder.genderMovie.text = movie.gender
        holder.reviewMovie.text = movie.reviews
        holder.imageMovie.setImageDrawable(movie.image)
    }

    override fun getItemCount() = movies.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameMovie = itemView.tv_name_movie
        val timeMovie = itemView.tv_time_movie
        val minAgeMovie = itemView.tv_age_movie
        val imageMovie = itemView.iv_movie
        val genderMovie = itemView.tv_gender_movie
        val reviewMovie = itemView.tv_reviews_movie
    }
}