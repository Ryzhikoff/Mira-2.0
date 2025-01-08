package utils

import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.files.SystemTemporaryDirectory

internal class DeviceStorageCommon : DeviceStorage{

    override fun getPathForEmotion(): String {

        val filePath = "$SystemTemporaryDirectory$EMOTION_PATH/"

        println("SystemFileSystem.exists(Path(filePath)): ${SystemFileSystem.exists(Path(filePath))}")
        if (!SystemFileSystem.exists(Path(filePath))) {
            SystemFileSystem.createDirectories(Path(filePath))
        }
        println("SystemFileSystem.exists(Path(filePath)): ${SystemFileSystem.exists(Path(filePath))}")

        return filePath
    }

    private companion object {
        const val EMOTION_PATH = "/emotion"
    }
}

/*
    Android native
 */
//internal class DeviceStorageImpl(
//    private val context: Context
//) : DeviceStorage {
//
//    override fun getPathForEmotion(fileName: String): String {
//
//        val baseDirectory = context.filesDir
//        val emotionDirectory = File(baseDirectory, EMOTION_PATH)
//
//        if (!emotionDirectory.exists()) {
//            emotionDirectory.mkdirs()
//        }
//
//        return File(emotionDirectory, fileName).absolutePath
//    }
//
//    private companion object {
//        const val EMOTION_PATH = "emotion"
//    }
//}