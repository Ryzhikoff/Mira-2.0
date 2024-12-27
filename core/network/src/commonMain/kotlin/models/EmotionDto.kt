package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmotionDto(
    @SerialName("name")
    val name: String,
    @SerialName("name_genitive")
    val nameGenitive: String,
    @SerialName("emoji_link")
    val emojiLink: String,
    @SerialName("is_positive")
    val isPositive: Boolean,
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
    @SerialName("exercises")
    val exercisePreviewDtos: List<ExercisePreviewDto>,
    @SerialName("id")
    val id: Int
)

fun EmotionDto.toEmotion() =
    Emotion(
        id = id,
        name = name,
        nameGenitive = nameGenitive,
        isPositive = isPositive,
        remoteEmojiLink = emojiLink,
        emojiLink = emojiLink,
        isOpened = false,
    )