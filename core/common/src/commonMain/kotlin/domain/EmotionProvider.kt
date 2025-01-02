package domain

interface EmotionProvider {

    suspend fun open(emotionId: Int)

    
}