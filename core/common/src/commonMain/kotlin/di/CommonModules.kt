package di

import data.CheckInRepositoryImpl
import data.EmotionRepositoryImpl
import data.di.storageModule
import domain.CheckInRepository
import domain.EmotionRepository
import domain.PrepareEmotionsUseCase
import org.koin.dsl.module
import utils.DeviceStorage
import utils.DeviceStorageCommon

internal val commonModule = module {
    single<CheckInRepository> { CheckInRepositoryImpl(get()) }
    single<EmotionRepository> { EmotionRepositoryImpl(get(), get()) }
    single<DeviceStorage> { DeviceStorageCommon() }
    single { PrepareEmotionsUseCase(get(), get(), get()) }
}

val commonModules = listOf(
    commonModule,
    storageModule,
    networkModule,
)