package data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

internal class HttpClientBuilder private constructor(
    val httpClient: HttpClient,
) {

    companion object {
        private var httpClientBuilder: HttpClientBuilder? = null

        internal fun getInstance(): HttpClientBuilder =
            httpClientBuilder ?: createNewClient().also {
                httpClientBuilder = it
            }

        private fun createNewClient(): HttpClientBuilder =
            HttpClientBuilder(
                HttpClient {
                    install(ContentNegotiation) {
                        json(
                            Json {
                                ignoreUnknownKeys = true
                                useAlternativeNames = true
                                coerceInputValues = true
                            }
                        )
                    }

                    install(Logging) {
                        logger = object : Logger {
                            override fun log(message: String) {
                                println(message)
                            }
                        }
//                        level = LogLevel.INFO
                        level = LogLevel.ALL
                    }

                    install(HttpTimeout) {
                        requestTimeoutMillis = ApiConstants.REQUEST_TIMEOUT_MILLIS
                    }

                    defaultRequest {
                        url(ApiConstants.BASE_URL)
                    }
                }
            )
    }
}