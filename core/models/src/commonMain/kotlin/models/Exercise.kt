package models

data class Exercise(
    val id: Int,
    val name: String,
    val description: String,
    val previewImageLink: String,
    val emotionsId: List<Int>,
    val screens: List<ExerciseScreen>,
    val isIntro: Boolean = false,
    val isOpened: Boolean = false
)