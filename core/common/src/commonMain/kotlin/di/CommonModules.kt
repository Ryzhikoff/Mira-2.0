package di

import data.CheckInRepositoryImpl
import data.di.storageModule
import domain.CheckInRepository
import org.koin.dsl.module

internal val commonModule = module {
    single<CheckInRepository> { CheckInRepositoryImpl(get()) }
}

val commonModules = listOf(
    storageModule,
    commonModule
)