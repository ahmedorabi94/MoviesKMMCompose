package com.movies.presentation.movie_list

import com.movies.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val movies: List<Movie> = listOf()
) {
    constructor() : this(
        isLoading = false,
        page = 1,
        query = "",
        movies = listOf()
    )
}