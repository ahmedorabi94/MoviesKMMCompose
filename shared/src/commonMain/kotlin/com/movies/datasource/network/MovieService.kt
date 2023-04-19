package com.movies.datasource.network

import com.movies.domain.model.MovieResponse
import com.movies.domain.model.get_movie.MovieDetailResponse


interface MovieService {

    suspend fun getNowPlayingMoviesAsync(page: Int): MovieResponse
    suspend fun getMovieDetailsAsync(movieId: Int): MovieDetailResponse
    suspend fun searchMoviesApi(query: String): MovieResponse

}