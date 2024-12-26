package di

import data.database.DatabaseDriverFactory
import database.IOSDatabaseDriverFactory
import org.koin.dsl.module

val iosStorageModule = module {
    single<DatabaseDriverFactory> { IOSDatabaseDriverFactory() }
}