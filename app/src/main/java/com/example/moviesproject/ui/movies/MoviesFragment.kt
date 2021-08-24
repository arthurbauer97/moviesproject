package com.example.moviesproject.ui.movies

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesproject.databinding.FragmentMoviesBinding
import com.example.moviesproject.domain.model.Genre
import com.example.moviesproject.domain.model.Movie
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModel()

    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerVMEvents()

        binding.clMovies.visibility = View.GONE
        binding.pbMovies.visibility = View.VISIBLE

        viewModel.getGeneres()
        viewModel.getMovies()
        viewModel.getMoviesUpcoming()
        viewModel.getMoviesTopRated()

    }

    private fun observerVMEvents() {

        var genres = listOf<Genre>()

        viewModel.genres.observe(viewLifecycleOwner) {
            genres = it
        }

        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            val adapter1 = MoviesAdapter(movies,genres)
            binding.rvMovies1.adapter = adapter1

            binding.rvMovies1.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.moviesTopRated.observe(viewLifecycleOwner) { moviesTopRated ->
            val adapter2 = MoviesAdapter(moviesTopRated,genres)
            binding.rvMovies2.adapter = adapter2

            binding.rvMovies2.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.moviesUpcoming.observe(viewLifecycleOwner) { moviesUpcoming ->
            val adapter3 = MoviesAdapter(moviesUpcoming,genres)
            binding.rvMovies3.adapter = adapter3

            binding.rvMovies3.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            binding.clMovies.visibility = View.VISIBLE
            binding.pbMovies.visibility = View.GONE
        }
    }
}