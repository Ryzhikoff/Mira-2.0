package domain

import models.ApiResponse

interface ExerciseRepository {

    suspend fun getIntroExerciseFromApi(): ApiResponse

    suspend fun getExercisesListByEmotionId(emotionId: Int): ApiResponse

    suspend fun getAllExercisesFromApi(): ApiResponse

//    private suspend fun <T> getExercisesList(
//        apiCall: suspend () -> ApiResponse<T>
//    ): ApiResponse

//    suspend fun getRandomExercise(exercises: ExerciseDtoList): ApiResponse

    suspend fun getExerciseById(id: Int): ApiResponse

    fun isOpenExercise(exerciseId: Int): Boolean

    fun openExercise(exerciseId: Int)
}
