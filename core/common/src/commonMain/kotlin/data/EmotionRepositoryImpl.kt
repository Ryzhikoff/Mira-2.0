package data

import data.domain.DatabaseRepository
import domain.EmotionRepository
import domain.ApiRepository
import models.ApiResponse
import models.Emotion

internal class EmotionRepositoryImpl(
    private val api: ApiRepository,
    private val database: DatabaseRepository,
) : EmotionRepository {

    override suspend fun getEmotionsFromApi(): ApiResponse<List<Emotion>> {
        return api.getEmotions()
    }

    override suspend fun getEmotionsFromDb(): List<Emotion> {
        return database.getEmotions()
    }

    override suspend fun writeEmotionToDb(emotion: Emotion) {
        database.insertEmotion(emotion)
    }

    override suspend fun deleteEmotions(emotions: List<Emotion>) {
        database.deleteEmotions(emotions)
    }

    override suspend fun openEmotion(emotionId: Int) {
        database.openEmotion(emotionId)
    }
}