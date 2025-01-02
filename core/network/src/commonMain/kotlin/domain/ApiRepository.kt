package domain

import models.ApiResponse
import models.Emotion
import models.Exercise

interface ApiRepository {

    suspend fun getEmotions(): ApiResponse<List<Emotion>>

    suspend fun getIntroExercise(): ApiResponse<Exercise>

    suspend fun getExercisesByEmotionId(emotionId: Int, publishedOnly: Boolean,): ApiResponse<Unit>

    suspend fun getExercisesById(id: Int,): ApiResponse<Unit>

    suspend fun getAllExercises(includeIntro: Boolean, publishedOnly: Boolean): ApiResponse<Unit>
}