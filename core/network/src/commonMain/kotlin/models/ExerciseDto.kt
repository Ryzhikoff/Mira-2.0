package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDto(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("created_by")
    val createdBy: CreatedBy,
    @SerialName("description")
    val description: String,
    @SerialName("edited_at")
    val editedAt: String,
    @SerialName("edited_by")
    val editedBy: EditedBy,
    @SerialName("emotions")
    val emotions: List<EmotionDto>,
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
    @SerialName("screens")
    val screens: List<ScreenDto>?,
    @SerialName("title")
    val title: String?
)