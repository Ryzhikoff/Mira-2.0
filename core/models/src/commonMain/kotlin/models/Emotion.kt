package models

data class Emotion(
    val id: Int,
    val name: String,
    val nameGenitive: String,
    val isPositive: Boolean,
    val remoteEmojiLink: String,
    val emojiLink: String,
    var isOpened: Boolean
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Emotion

        if (id != other.id) return false
        if (name != other.name) return false
        if (nameGenitive != other.nameGenitive) return false
        if (isPositive != other.isPositive) return false
        if (remoteEmojiLink != other.remoteEmojiLink) return false
        if (emojiLink != other.emojiLink) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + nameGenitive.hashCode()
        result = 31 * result + isPositive.hashCode()
        result = 31 * result + remoteEmojiLink.hashCode()
        result = 31 * result + emojiLink.hashCode()
        return result
    }
}