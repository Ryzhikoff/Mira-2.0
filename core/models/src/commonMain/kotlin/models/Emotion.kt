package models

data class Emotion(
    val id: Int,
    val name: String,
    val nameGenitive: String,
    val isPositive: Boolean,
    val remoteEmojiLink: String,
    val emojiLink: String,
    var isOpened: Boolean
)