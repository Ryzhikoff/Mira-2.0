package domain

import models.ApiResponse
import models.Emotion

interface EmotionRepository {

    suspend fun getEmotionsFromApi(): ApiResponse

    suspend fun getEmotionsFromDb(): List<Emotion>

    suspend fun writeEmotionToDb(emotion: Emotion)

    suspend fun deleteEmotions(emotions: List<Emotion>)

    suspend fun openEmotion(emotionId: Int)
}