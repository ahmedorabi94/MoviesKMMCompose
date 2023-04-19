package com.movies.datasource.network

import com.movies.domain.model.MovieResponse
import com.movies.domain.model.get_movie.MovieDetailResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.*
import io.ktor.client.plugins.HttpTimeout


class MovieServiceImp() : MovieService {


    override suspend fun getNowPlayingMoviesAsync(page: Int): MovieResponse {

        val strValue = httpclient.get {
            url("$BASE_URL/movie/now_playing?api_key=$apiKey&page=$page")
        }

        return strValue.body()

    }

    override suspend fun searchMoviesApi(query: String): MovieResponse {

        val strValue = httpclient.get {
            url("$BASE_URL/search/multi?api_key=$apiKey&query=$query")

        }

        return strValue.body()
    }

    override suspend fun getMovieDetailsAsync(movieId: Int): MovieDetailResponse {

        val strValue = httpclient.get {
            url("$BASE_URL/movie/$movieId?api_key=$apiKey")
        }

        return strValue.body()
    }

    companion object {
        const val apiKey: String = "97c261053713fdbd691f42aa664c1463"
        const val BASE_URL = "https://api.themoviedb.org/3"

    }

    private val httpclient = HttpClient {
        expectSuccess = true
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
        install(ContentNegotiation) {
            json()
        }
    }


}