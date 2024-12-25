package site.pnpl.mira.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import site.pnpl.mira.data.database.AndroidDatabaseDriverFactory
import site.pnpl.mira.data.database.DatabaseDriverFactory

val androidModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
}