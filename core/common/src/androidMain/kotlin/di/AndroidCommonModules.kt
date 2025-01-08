package di

import org.koin.dsl.module

internal val utilsAndroidModule = module {
//    single<DeviceStorage> { DeviceStorageImpl(androidContext()) }
}

val androidCommonModules = androidStorageModule + utilsAndroidModule