package di

import data.HttpClientBuilder
import data.NetworkRepositoryImpl
import domain.NetworkRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single<NetworkRepository> { NetworkRepositoryImpl(get()) }
    single<HttpClient> { HttpClientBuilder.getInstance().httpClient }
}