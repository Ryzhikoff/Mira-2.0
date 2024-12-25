package data.database.entities

data class CheckInEntity(
    val id: Int = 0,
    val emotionId: Int,
    val factorId: Int,
    val exercisesId: Int = 0,
    val note: String = "",
    val createdAt: String,
    val createdAtLong: Long,
    val editedAt: String = "",
    val isSynchronized: Int = 0
)