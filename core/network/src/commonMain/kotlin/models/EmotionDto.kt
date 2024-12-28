package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmotionDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("name_genitive")
    val nameGenitive: String,
    @SerialName("emoji_link")
    val emojiLink: String,
    @SerialName("is_positive")
    val isPositive: Boolean,
    @SerialName("description")
    val description: String,
    @SerialName("exercises")
    val exercisePreviewDtos: List<ExercisePreviewDto>,
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