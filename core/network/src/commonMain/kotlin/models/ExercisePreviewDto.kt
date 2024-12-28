package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExercisePreviewDto(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("is_intro")
    val isIntro: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("preview_image_link")
    val previewImageLink: String,
    @SerialName("published")
    val published: Boolean,
    @SerialName("title")
    val title: String?
)