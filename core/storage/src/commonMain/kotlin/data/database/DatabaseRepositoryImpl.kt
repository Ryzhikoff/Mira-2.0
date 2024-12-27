package data.database

import data.domain.DatabaseRepository
import models.CheckIn
import models.Emotion
import models.Exercise
import site.pnpl.mira.data.database.AppDatabase

internal class DatabaseRepositoryImpl(
    databaseDriverFactory: DatabaseDriverFactory,
) : DatabaseRepository {

    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    override suspend fun getAllCheckIns(): List<CheckIn> =
        dbQuery.selectAllCheckIns(::mapCheckInSelecting).executeAsList()

    override suspend fun insertCheckIn(checkIn: CheckIn) {
        with(checkIn) {
            dbQuery.insertCheckIn(
                emotion_id = emotionId.toLong(),
                factor_id = factorId.toLong(),
                exercises_id = exercisesId.toLong(),
                note = note,
                created_at = createdAt,
                created_at_long = createdAtLong,
                edited_at = editedAt,
                is_synchronized = if (isSynchronized) 1 else 0
            )
        }
    }

    override suspend fun getCheckInForPeriod(
        startPeriod: Long,
        endPeriod: Long,
    ): List<CheckIn> =
        dbQuery.selectCheckInsForPeriod(
            startPeriod.toString(),
            endPeriod.toString(),
            (::mapCheckInSelecting)
        ).executeAsList()

    override suspend fun getCheckInForPeriodByFactorId(
        startPeriod: Long,
        endPeriod: Long,
        factorId: Int,
    ): List<CheckIn> =
        dbQuery.selectCheckInsForPeriodByFactor(
            startPeriod.toString(),
            endPeriod.toString(),
            factorId.toLong(),
            (::mapCheckInSelecting)
        ).executeAsList()

    override suspend fun insertListOfCheckIns(checkIns: List<CheckIn>) {
        checkIns.forEach {
            insertCheckIn(it)
        }
    }

    override suspend fun deleteListOfCheckIns(checkIns: List<CheckIn>) {
        checkIns.forEach {
            dbQuery.deleteCheckInById(it.id.toLong())
        }
    }

    override suspend fun getCountCheckIns(): Long =
        dbQuery.countAllCheckIns().executeAsOne()

    override suspend fun getCountCheckInsByFactor(factorId: Int): Long =
        dbQuery.countCheckInsByFactorId(factorId.toLong()).executeAsOne()

    override suspend fun getEmotions(): List<Emotion> =
        dbQuery.selectAllEmotions(::mapEmotionSelecting).executeAsList()

    override suspend fun insertEmotion(emotion: Emotion) {
        with(emotion) {
            dbQuery.insertEmotion(
                id = id.toLong(),
                name = name,
                name_genitive = nameGenitive,
                remote_emoji_link = remoteEmojiLink,
                local_emoji_link = emojiLink,
                is_positive = if (isPositive) 1 else 0,
                is_opened = if (isOpened) 1 else 0,
            )
        }
    }

    override suspend fun deleteEmotions(emotions: List<Emotion>) {
        dbQuery.deleteEmotions(emotions.map { it.id.toLong() })
    }

    override suspend fun openEmotion(emotionId: Int) {
        dbQuery.updateEmotionOpenedFlag(1, emotionId.toLong())
    }

    override suspend fun insertExercise(exercise: Exercise) {
        dbQuery.insertExercise(
            exercise_id = exercise.id.toLong(),
            is_opened = if (exercise.isOpened) 1 else 0
        )
    }

    override suspend fun isExistExercise(exerciseId: Int): Boolean {
        dbQuery.selectExerciseById(exerciseId.toLong()).executeAsOneOrNull() ?: return false
        return true
    }

    private fun mapEmotionSelecting(
        id: Long,
        name: String,
        nameGenitive: String,
        remoteEmojiLink: String,
        localEmojiLink: String,
        isPositive: Long,
        isOpened: Long,
    ) = Emotion(
        id = id.toInt(),
        name = name,
        nameGenitive = nameGenitive,
        remoteEmojiLink = remoteEmojiLink,
        emojiLink = localEmojiLink,
        isPositive = isPositive.toInt() == 1,
        isOpened = isOpened.toInt() == 1,
    )

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
    ) = CheckIn(
        id = id.toInt(),
        emotionId = emotionId.toInt(),
        factorId = factorId.toInt(),
        exercisesId = exercisesId.toInt(),
        note = note,
        createdAt = createdAt,
        createdAtLong = createdAtLong,
        editedAt = editedAt,
        isSynchronized = isSynchronized.toInt() == 1,
        isSelected = false,
    )

}