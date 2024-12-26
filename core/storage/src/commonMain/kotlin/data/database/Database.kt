package data.database

import data.database.entities.CheckInEntity
import models.CheckIn
import site.pnpl.mira.data.database.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAllCheckIns(): List<CheckInEntity> {
        return dbQuery.selectAllCheckIns(::mapCheckInSelecting).executeAsList()
    }

    internal fun insertCheckIn(checkIn: CheckInEntity) {
        with(checkIn) {
            dbQuery.insertCheckIn(
                emotion_id = emotionId,
                factor_id = factorId,
                exercises_id = exercisesId,
                note = note,
                created_at = createdAt,
                created_at_long = createdAtLong,
                edited_at = editedAt,
                is_synchronized = isSynchronized
            )
        }
    }

    internal fun getCheckInForPeriod(startPeriod: String, endPeriod: String): List<CheckInEntity> {
        return dbQuery.selectCheckInsForPeriod(
            startPeriod,
            endPeriod,
            (::mapCheckInSelecting)
        ).executeAsList()
    }

    internal fun getCheckInForPeriodByFactorId(
        startPeriod: String,
        endPeriod: String,
        factorId: Long
    ): List<CheckInEntity> =
        dbQuery.selectCheckInsForPeriodByFactor(
            startPeriod,
            endPeriod,
            factorId,
            (::mapCheckInSelecting)
        ).executeAsList()

    internal fun deleteCheckInById(checkInId: Long) {
        dbQuery.deleteCheckInById(checkInId)
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
    ): CheckInEntity {
        return CheckInEntity(
            id = id,
            emotionId = emotionId,
            factorId = factorId,
            exercisesId = exercisesId,
            note = note,
            createdAt = createdAt,
            createdAtLong = createdAtLong,
            editedAt = editedAt,
            isSynchronized = isSynchronized,
        )
    }
}