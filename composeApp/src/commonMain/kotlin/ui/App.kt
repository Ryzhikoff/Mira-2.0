package ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import di.sharedModules
import org.koin.compose.KoinContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import ui.screens.splash.SplashScreen

fun initKoin(modules: List<Module> = emptyList()) {
    startKoin {
        modules(sharedModules + modules)
    }
}

@Composable
fun App() {
    KoinContext {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Routing.Splash) {

            composable<Routing.Splash> {
                SplashScreen()
            }
        }
    }
}