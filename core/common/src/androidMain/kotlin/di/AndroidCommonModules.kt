package di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import utils.DeviceStorage
import utils.DeviceStorageImpl

internal val utilsAndroidModule = module {
    single<DeviceStorage> { DeviceStorageImpl(androidContext()) }
}

val androidCommonModules = androidStorageModule + utilsAndroidModule