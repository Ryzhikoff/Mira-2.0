package data.database

import models.CheckIn
import site.pnpl.mira.data.database.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal suspend fun getAllCheckIns(): List<CheckIn> {
        return dbQuery.selectAllCheckIns(::mapCheckInSelecting).executeAsList()

    }

    private fun mapCheckInSelecting(
        id: Long,
        emotionId: Long,
        factorId: Long,
        exercisesId: Long,
        note: String,
        createdAt: String,
        createdAtLong: Long,
        editedAt: String,
        isSynchronized: Long,
    ): CheckIn {
        return CheckIn(
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
    }
}