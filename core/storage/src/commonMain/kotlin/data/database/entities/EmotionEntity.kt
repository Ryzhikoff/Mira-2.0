package data.database.entities

data class EmotionEntity(
    val id: Int,
    val name: String,
    val nameGenitive: String,
    val remoteEmojiLink: String,
    val localEmojiLink: String,
    val isPositive: Int,
    val isOpened: Int
)