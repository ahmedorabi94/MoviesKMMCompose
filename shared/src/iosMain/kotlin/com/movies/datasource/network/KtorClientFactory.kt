package com.movies.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual class KtorClientFactory {

    actual fun build(): HttpClient {

        return HttpClient(Ios) {
            install(ContentNegotiation) {
                json()
//                serializer = KotlinxSerializer(
//                    Json {
//                        explicitNulls = false
//                        coerceInputValues = true
//                        ignoreUnknownKeys = true // if the server sends extra fields, ignore them
//                    }
//                )
            }
        }
    }
}