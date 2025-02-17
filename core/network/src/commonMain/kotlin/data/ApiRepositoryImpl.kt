package data

import data.ApiConstants.GET_EMOTIONS
import domain.ApiRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import models.ApiResponse
import models.Emotion
import models.EmotionDto
import models.Exercise
import models.toEmotion

internal class ApiRepositoryImpl(
    private val client: HttpClient,
) : ApiRepository {

    override suspend fun getEmotions(): ApiResponse<List<Emotion>> =
        getRequest<List<EmotionDto>, List<Emotion>>(
            path = GET_EMOTIONS,
            mapper = { emotionDtos ->
                emotionDtos.map {
                    it.toEmotion()
                }
            }
        )

    override suspend fun getIntroExercise(): ApiResponse<Exercise> {
        TODO("Not yet implemented")
    }

    override suspend fun getExercisesByEmotionId(emotionId: Int, publishedOnly: Boolean): ApiResponse<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getExercisesById(id: Int): ApiResponse<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExercises(includeIntro: Boolean, publishedOnly: Boolean): ApiResponse<Unit> {
        TODO("Not yet implemented")
    }

    private suspend inline fun <reified T : Any, R> getRequest(
        path: String,
        params: Map<String, String> = emptyMap(),
        noinline mapper: ((T) -> R),
    ): ApiResponse<R> =
        try {
            val response = client.get(path) {
                url {
                    params.forEach { (key, value) ->
                        parameters.append(key, value)
                    }
                }
            }
            handleResponse<T, R>(response, mapper)
        } catch (e: Exception) {
            ApiResponse.Error.Connection("Connection to server failed:\n${e.printStackTrace()}")
        }

    private suspend inline fun <reified T : Any, R> handleResponse(
        response: HttpResponse,
        noinline mapper: ((T) -> R),
    ): ApiResponse<R> =
        when (response.status.value) {
            in 200..299 -> {
                val result = response.body() as T
                ApiResponse.Success(mapper(result))
            }
            in 400 .. 499 -> ApiResponse.Error.Internal(response.status.value, "")
            else -> ApiResponse.Error.Internal(response.status.value, "Unexpected response from the server")
        }
}