package models.dto.exercises

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EditedBy(
    @SerialName("email")
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("username")
    val username: String
)