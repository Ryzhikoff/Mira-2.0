package di

import org.koin.dsl.module
import data.database.AndroidDatabaseDriverFactory
import data.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext

val androidStorageModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
}