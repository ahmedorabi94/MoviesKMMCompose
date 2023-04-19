package com.movies.datasource.network

import io.ktor.client.*

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.awt.Desktop

actual class KtorClientFactory {


    actual fun build(): HttpClient {
        return HttpClient() {
//            install(Logging) {
//                logger = Logger.ANDROID
//                level = LogLevel.BODY
//            }

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