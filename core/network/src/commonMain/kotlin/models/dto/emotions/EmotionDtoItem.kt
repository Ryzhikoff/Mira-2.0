package models.dto.emotions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import site.pnpl.mira.data.remote.dto.emotions.CreatedBy
import site.pnpl.mira.data.remote.dto.emotions.EditedBy
import site.pnpl.mira.data.remote.dto.emotions.ExerciseDto

@Serializable
data class EmotionDtoItem(
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
    val exerciseDtos: List<ExerciseDto>,
    @SerialName("id")
    val id: Int
)