package domain

import io.github.vinceglb.filekit.core.FileKit
import kotlinx.io.Buffer
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.files.SystemTemporaryDirectory
import models.ApiResponse
import models.Emotion
import utils.DeviceStorage


class PrepareEmotionsUseCase(
    private val emotionRepository: EmotionRepository,
    private val downloadManager: DownloadManager,
    private val deviceStorage: DeviceStorage,
) {

    suspend operator fun invoke(onComplete: (Boolean) -> Unit) {
        val apiEmotions: List<Emotion> = getEmotionsFromApi()
        val savedEmotions: List<Emotion> = emotionRepository.getEmotionsFromDb()

        if (apiEmotions.isEmpty()) {
            onComplete(false)
            return
        }

        println(apiEmotions)

        apiEmotions.forEach { emotion ->
            if (!savedEmotions.contains(emotion) || !isEmotionDownloaded(emotion)) {
                val result = downloadAndSaveEmotion(emotion)
                println("${emotion.name} result $result")
            }
        }

        onComplete(true)

    }

    private suspend fun downloadAndSaveEmotion(emotion: Emotion): Boolean {
        val byteArray: ByteArray? = downloadManager.download(emotion.remoteEmojiLink)
        if (byteArray != null) {

            val nameForSaved = emotion.remoteEmojiLink
                .split("/")
                .last()
                .split(".")[0]

            val extension = emotion.remoteEmojiLink
                .split("/")
                .last()
                .split(".")[1]

//            val filePCath = deviceStorage.getPathForEmotion()

            val file = FileKit.saveFile(
                bytes = byteArray,
                baseName = nameForSaved,
                extension = extension,
//                initialDirectory = "emotion"
            )

            println(file?.path)

//            Buffer().write(byteArray)
//
//            File(filePath).outputStream().use { outputStream ->
//                val writer = outputStream.toOutput()
//                writer.writeFully(response)
//            }
            return true
        } else {
            return false
        }
    }

    private fun isEmotionDownloaded(emotion: Emotion): Boolean {
        return true
    }

    /**
     *  @return List of Emotions if request success, else - emptyList
     */
    private suspend fun getEmotionsFromApi(): List<Emotion> {
        val response = emotionRepository.getEmotionsFromApi()

        return if (response is ApiResponse.Success) {
            response.result
        } else {
            emptyList()
        }
    }

    // get from api
    // get from db
    // compare api and db
    // check exist downloads
    // downloads if not exist
}