package com.movies.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.android.*

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual class KtorClientFactory {


    actual fun build(): HttpClient {
        return HttpClient(Android) {
            expectSuccess = true
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.BODY
            }

            install(ContentNegotiation) {
                json()
//                    Json {
//                        isLenient = true
//                        prettyPrint = true
//                        encodeDefaults = true
//
//                    }
            }

        }
    }
}