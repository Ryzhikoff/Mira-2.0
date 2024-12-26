package data.database.entities

data class CheckInEntity(
    val id: Long = 0,
    val emotionId: Long,
    val factorId: Long,
    val exercisesId: Long = 0,
    val note: String = "",
    val createdAt: String,
    val createdAtLong: Long,
    val editedAt: String = "",
    val isSynchronized: Long = 0
)