package com.example.moviesproject.ui.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesproject.R
import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MoviesAdapter(
    var movies: List<Movie>,
    var genres: List<Genre>
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
        viewHolder.rating.text = movie.vote_average

        viewHolder.reviewMovie.text = movie.vote_count.toString()

        //photo glide
        var movieUrl = "https://themoviedb.org/t/p/w300_and_h450_bestv2/" + movie.poster_path
        Glide.with(context).load(movieUrl).into(viewHolder.imageMovie)


        //genre filter
        var listOfNames = mutableListOf<String>()
        genres.forEach {
            if (movie.genre_ids.contains(it.id)){
                listOfNames.add(it.name)
                val stringOfNames = listOfNames.joinToString(", ")
                viewHolder.genderMovie.text = stringOfNames
            }
        }

        //date convert
        val date = SimpleDateFormat("yyyy-MM-dd").parse(movie.release_date)
        val newFormat = SimpleDateFormat("dd/MM/yyyy")
        val netDate = Date(date.time)
        val newDate = newFormat.format(netDate)

        viewHolder.dateMovie.text = newDate
    }

    override fun getItemCount() = movies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameMovie = itemView.tv_name_movie
        val dateMovie = itemView.tv_date_movie
        val genderMovie = itemView.tv_gender_movie
        val rating = itemView.tv_rating_movie
        val imageMovie = itemView.iv_movie
        val reviewMovie = itemView.tv_reviews_movie
    }
}