package data.di

import data.database.Database
import data.database.DatabaseRepositoryImpl
import data.domain.DatabaseRepository
import org.koin.dsl.module

val storageModule = module {
    single<Database> { Database(get()) }
    single<DatabaseRepository> { DatabaseRepositoryImpl(get()) }
}