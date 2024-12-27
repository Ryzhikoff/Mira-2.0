package site.pnpl.mira.data.remote.dto.emotions


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ExerciseDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_intro")
    val isIntro: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("preview_image_link")
    val previewImageLink: String,
    @SerializedName("published")
    val published: Boolean,
    @SerializedName("title")
    val title: String
)