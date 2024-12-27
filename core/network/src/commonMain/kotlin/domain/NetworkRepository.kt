package domain

import models.ApiResponse

interface NetworkRepository {

    suspend fun getEmotions(): ApiResponse

    suspend fun getIntroExercise(): ApiResponse

    suspend fun getExercisesByEmotionId(emotionId: Int, publishedOnly: Boolean,): ApiResponse

    suspend fun getExercisesById(id: Int,): ApiResponse

    suspend fun getAllExercises(includeIntro: Boolean, publishedOnly: Boolean): ApiResponse
}