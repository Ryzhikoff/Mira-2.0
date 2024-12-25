package data

import data.database.Database
import domain.CheckInRepository
import org.koin.dsl.module

val dataModule = module {
    single { Database(get()) }
    single<CheckInRepository> { CheckInRepositoryImpl(get())}
}