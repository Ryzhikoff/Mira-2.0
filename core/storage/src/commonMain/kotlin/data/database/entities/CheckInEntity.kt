package data.database.entities

import models.CheckIn

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

fun CheckInEntity.toCheckIn(): CheckIn =
    CheckIn(
        id = id.toInt(),
        emotionId = emotionId.toInt(),
        factorId = factorId.toInt(),
        exercisesId = exercisesId.toInt(),
        note = note,
        createdAt = createdAt,
        createdAtLong = createdAtLong,
        editedAt = editedAt,
        isSynchronized = isSynchronized.toInt() == 1,
        isSelected = false
    )

fun CheckIn.toEntity(): CheckInEntity =
    CheckInEntity(
        id = id.toLong(),
        emotionId = emotionId.toLong(),
        factorId = factorId.toLong(),
        exercisesId = exercisesId.toLong(),
        note = note,
        createdAt = createdAt,
        createdAtLong = createdAtLong,
        editedAt = editedAt,
        isSynchronized = if (isSynchronized) 1 else 0
    )