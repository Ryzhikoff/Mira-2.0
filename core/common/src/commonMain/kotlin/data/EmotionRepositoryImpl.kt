package data

import domain.EmotionRepository
import domain.NetworkRepository
import models.ApiResponse
import models.Emotion

internal class EmotionRepositoryImpl(
    private val networkRepository: NetworkRepository,
) : EmotionRepository {

    override suspend fun getEmotionsFromApi(): ApiResponse {
        return networkRepository.getEmotions()
    }

    override suspend fun getEmotionsFromDb(): List<Emotion> {
        TODO("Not yet implemented")
    }

    override suspend fun writeEmotionToDb(emotion: Emotion) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEmotions(emotions: List<Emotion>) {
        TODO("Not yet implemented")
    }

    override suspend fun openEmotion(emotionId: Int) {
        TODO("Not yet implemented")
    }
}