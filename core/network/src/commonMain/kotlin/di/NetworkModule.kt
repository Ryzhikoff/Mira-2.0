package di

import data.HttpClientBuilder
import data.ApiRepositoryImpl
import data.DownloadManagerImpl
import domain.ApiRepository
import domain.DownloadManager
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single<ApiRepository> { ApiRepositoryImpl(get()) }
    single<HttpClient> { HttpClientBuilder.getInstance().httpClient }

    factory<DownloadManager> { DownloadManagerImpl() }
}