package ui.screens.splash

import SPLASH_GIF_PATH
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.panpf.sketch.AsyncImage
import com.github.panpf.sketch.fetch.newComposeResourceUri
import mira.shared.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.themes.Colors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen() {
    Box {

        Box(modifier = Modifier.fillMaxSize().background(color = Colors.white)) {
            AsyncImage(
                modifier = Modifier.align(Alignment.Center),
                uri = newComposeResourceUri(Res.getUri(SPLASH_GIF_PATH)),
                contentDescription = null
            )
        }
    }
}