package com.movies.domain.model

import com.movies.domain.model.Dates
import com.movies.domain.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
 //   val id : Long,
    val dates: Dates? =null,
    val page: Long,
    val results: List<Movie>,
    val total_pages: Long,
    val total_results: Long
)