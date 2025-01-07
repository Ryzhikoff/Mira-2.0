package ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import ui.screens.splash.SplashScreen

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