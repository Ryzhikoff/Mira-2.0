package site.pnpl.mira.ip

import androidx.compose.ui.window.ComposeUIViewController
import di.iosModules
import ui.App
import ui.initKoin

@Suppress("Unused")
fun MainViewController() = ComposeUIViewController {

    initKoin(iosModules)

    App()
}