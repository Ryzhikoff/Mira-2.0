package data.domain

import models.CheckIn
import models.Emotion
import models.Exercise

interface DatabaseRepository {

    suspend fun getAllCheckIns() : List<CheckIn>

    suspend fun insertCheckIn(checkIn: CheckIn)

    suspend fun getCheckInForPeriod(startPeriod: Long, endPeriod: Long): List<CheckIn>

    suspend fun getCheckInForPeriodByFactorId(startPeriod: Long, endPeriod: Long, factorId: Int): List<CheckIn>

    suspend fun insertListOfCheckIns(checkIns: List<CheckIn>)

    suspend fun deleteListOfCheckIns(checkIns: List<CheckIn>)

    suspend fun getCountCheckIns(): Long

    suspend fun getCountCheckInsByFactor(factorId: Int): Long

    suspend fun getEmotions(): List<Emotion>

    suspend fun insertEmotion(emotion: Emotion)

    suspend fun deleteEmotions(emotions: List<Emotion>)

    suspend fun openEmotion(emotionId: Int)

    suspend fun insertExercise(exercise: Exercise)

    suspend fun isExistExercise(exerciseId: Int): Boolean
}