package models

data class CheckIn (
    val id: Int,
    val emotionId: Int,
    val factorId: Int,
    val exercisesId: Int = 0,
    val note: String = "",
    val createdAt: String,
    val createdAtLong: Long,
    val editedAt: String = "",
    val isSynchronized: Boolean = false,
    var isSelected: Boolean,
//    val typeItem: Int = TYPE_ITEM_CHECK_IN
)