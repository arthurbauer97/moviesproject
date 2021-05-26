package com.example.moviesproject

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesproject.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    var listMovies1 = mutableListOf<Movie>()
    var listMovies2 = mutableListOf<Movie>()
    var listMovies3 = mutableListOf<Movie>()
    var listMovies4 = mutableListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {

        val movie1 = ContextCompat.getDrawable(requireContext(),R.drawable.movie1)
        val movie2 = ContextCompat.getDrawable(requireContext(),R.drawable.movie2)
        val movie3 = ContextCompat.getDrawable(requireContext(),R.drawable.movie3)
        val movie4 = ContextCompat.getDrawable(requireContext(),R.drawable.movie4)

        listMovies1.add(Movie("Vingadores 1", "180 min","14+", movie1,"870", "Terror, Comédia"))
        listMovies1.add(Movie("Vingadores 2", "90 min","18+", movie2,"543", "Terror, Magia"))
        listMovies1.add(Movie("Vingadores 3", "140 min","12+", movie3,"3454", "Terror, Magia"))
        listMovies1.add(Movie("Vingadores 4", "150 min","18+", movie4,"365", "Terror, Magia"))
        listMovies1.add(Movie("Vingadores 5", "130 min","14+", movie1,"234", "Comédia, Action"))
        listMovies1.add(Movie("Vingadores 6", "120 min","14+", movie3,"436", "Terror, Action, Adventure, Comédia"))
        listMovies1.add(Movie("Vingadores 7", "180 min","12+", movie4,"756", "Terror, Magia"))
        listMovies1.add(Movie("Vingadores 8", "180 min","12+", movie2,"870", "Adventure, Magia"))
        listMovies1.add(Movie("Vingadores 9", "180 min","18+", movie1,"346", "Action, Drama"))
        listMovies2.add(Movie("Vingadores", "180 min","14+", movie3,"657", "Action, Adventure, Drama"))
        listMovies2.add(Movie("Vingadores", "180 min","10+", movie4,"436", "Terror, Magia"))
        listMovies2.add(Movie("Vingadores", "180 min","14+", movie4,"534", "Comédia, Magia"))
        listMovies3.add(Movie("Vingadores", "180 min","10+", movie3,"532", "Adventure, Magia"))
        listMovies3.add(Movie("Vingadores", "180 min","10+", movie2,"124", "Terror, Magia"))
        listMovies3.add(Movie("Vingadores", "180 min","12+", movie4,"382", "Adventure, Drama"))
        listMovies3.add(Movie("Vingadores", "180 min","18+", movie1,"389", "Terror, Action, Comédia, Drama"))
        listMovies4.add(Movie("Vingadores", "180 min","14+", movie2,"720", "Terror, Suspense"))
        listMovies4.add(Movie("Vingadores", "180 min","14+", movie4,"999", "Terror"))
        listMovies4.add(Movie("Vingadores", "180 min","12+", movie2,"180", "Magia"))
        listMovies4.add(Movie("Vingadores", "180 min","18+", movie1,"320", "Ação, Suspense"))
        listMovies4.add(Movie("Vingadores", "180 min","18+", movie2,"200", "Suspense, Magia"))

        var adapter1 = MoviesAdapter(listMovies1)
        var adapter2 = MoviesAdapter(listMovies2)
        var adapter3 = MoviesAdapter(listMovies3)
        var adapter4 = MoviesAdapter(listMovies4)

        binding.rvMovies1.adapter = adapter1
        binding.rvMovies2.adapter = adapter2
        binding.rvMovies3.adapter = adapter3
        binding.rvMovies4.adapter = adapter4

        binding.rvMovies1.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMovies2.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMovies3.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMovies4.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }


}