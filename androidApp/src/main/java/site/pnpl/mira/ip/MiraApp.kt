package site.pnpl.mira.ip

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MiraApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MiraApp)
            androidLogger()
        }
    }
}