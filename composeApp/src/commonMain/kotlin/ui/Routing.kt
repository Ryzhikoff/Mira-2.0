package ui

import kotlinx.serialization.Serializable

sealed class Routing {

    @Serializable
    data object Splash : Routing()
}