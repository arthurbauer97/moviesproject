package com.example.moviesproject.di

import com.example.moviesproject.remote.ClientService
import com.example.moviesproject.data.MoviesDataService
import com.example.moviesproject.data.MoviesRepository
import com.example.moviesproject.domain.usecase.GetMoviesUseCase
import com.example.moviesproject.domain.usecase.GetMoviesUseCaseImpl
import com.example.moviesproject.ui.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ApiModuleKoin {

    //service
    private val serviceModule = module {
        single<MoviesDataService> {
            ClientService().configureServiceMovies()
        }
    }

    //useCaseMovies
    private val moviesUseCase = module {
        factory<GetMoviesUseCase>{
            GetMoviesUseCaseImpl(get())
        }
    }

    //viemodel
    private val viewModelModule = module {
        viewModel {
            MoviesViewModel(
                get()
            )
        }
    }

    //repository
    private val repositoryModule = module {
        single { MoviesRepository(get()) }
    }

    //useCaseMoviesImple
    private val moviesUseCaseImpl = module {
        single { GetMoviesUseCaseImpl(get()) }
    }

    val modules = listOf(viewModelModule, repositoryModule, serviceModule, moviesUseCaseImpl,moviesUseCase)
}