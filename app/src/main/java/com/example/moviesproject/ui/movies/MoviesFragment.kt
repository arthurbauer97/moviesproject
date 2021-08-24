package com.example.moviesproject.ui.movies

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesproject.databinding.FragmentMoviesBinding
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

    }

    private fun observerVMEvents() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            viewModel.genres.observe(viewLifecycleOwner){ genres ->
                val adapter1 = MoviesAdapter(movies,genres)
                val adapter2 = MoviesAdapter(movies,genres)
                val adapter3 = MoviesAdapter(movies,genres)
                val adapter4 = MoviesAdapter(movies,genres)

                binding.rvMovies1.adapter = adapter1
                binding.rvMovies2.adapter = adapter2
                binding.rvMovies3.adapter = adapter3
                binding.rvMovies4.adapter = adapter4

                binding.rvMovies1.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                binding.rvMovies2.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                binding.rvMovies3.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                binding.rvMovies4.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                binding.clMovies.visibility = View.VISIBLE
                binding.pbMovies.visibility = View.GONE

            }
        }
    }
}