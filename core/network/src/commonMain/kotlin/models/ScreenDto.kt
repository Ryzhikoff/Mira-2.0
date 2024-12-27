package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScreenDto(
    @SerialName("animation_link")
    val animationLink: String,
    @SerialName("sequence_number")
    val sequenceNumber: Int,
    @SerialName("text")
    val text: String,
    @SerialName("title")
    val title: String
)