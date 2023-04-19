package com.movies.use_cases

import com.movies.datasource.network.MovieService
import com.movies.domain.model.MovieResponse
import com.movies.domain.util.CommonFlow
import com.movies.domain.util.DataState
import com.movies.domain.util.asCommonFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviesUseCase(private val movieService: MovieService) {

    fun execute(page: Int): Flow<DataState<MovieResponse>> {

        return flow {

            emit(DataState.loading())
            try {
                val response = movieService.getNowPlayingMoviesAsync(page)
                emit(DataState.data(null, response))

            } catch (e: Exception) {
                emit(DataState.error(message = e.message ?: " "))
            }

        }

    }


}