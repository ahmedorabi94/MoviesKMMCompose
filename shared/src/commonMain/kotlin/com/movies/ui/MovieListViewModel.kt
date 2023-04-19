package com.movies.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.movies.datasource.network.MovieServiceImp
import com.movies.domain.model.Movie
import com.movies.presentation.movie_list.MovieListState
import com.movies.use_cases.GetMoviesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MovieListViewModel{

    private val viewModelScope = CoroutineScope(Dispatchers.Main)
    private val movieServiceImp = MovieServiceImp()
    private val useCase = GetMoviesUseCase(movieServiceImp)
   // val state = MutableStateFlow<MovieListState>(MovieListState())
    val state: MutableState<MovieListState> = mutableStateOf(MovieListState())


    init {

        viewModelScope.launch {
            useCase.execute(state.value.page)
                .collectLatest {  dataState ->

                    println("MovieListViewModel Loading ${dataState.isLoading}")

                    state.value = state.value.copy(isLoading = dataState.isLoading)

                    dataState.data?.let { movies ->
                        println("MovieListViewModel Results ${movies}")
                        //appendMovies(movies.results)

                        state.value = state.value.copy(movies = movies.results)
                    }

                    dataState.message?.let {
                        println("MovieListViewModel Error ${it}")

                    }


                }
        }

    }



    private fun appendMovies(movies: List<Movie>) {
        val curr = ArrayList(state.value.movies)
        curr.addAll(movies)
        state.value = state.value.copy(movies = curr)
    }


}