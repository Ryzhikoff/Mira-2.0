package utils

import android.content.Context
import java.io.File

internal class DeviceStorageImpl(
    private val context: Context
) : DeviceStorage {

    override fun getPathForEmotion(fileName: String): String {

        val baseDirectory = context.filesDir
        val emotionDirectory = File(baseDirectory, EMOTION_PATH)

        if (!emotionDirectory.exists()) {
            emotionDirectory.mkdirs()
        }

        return File(emotionDirectory, fileName).absolutePath
    }

    private companion object {
        const val EMOTION_PATH = "emotion"
    }
}