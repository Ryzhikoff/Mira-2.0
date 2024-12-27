package data.di

import data.database.DatabaseRepositoryImpl
import data.domain.DatabaseRepository
import org.koin.dsl.module

val storageModule = module {
    single<DatabaseRepository> { DatabaseRepositoryImpl(get()) }
}