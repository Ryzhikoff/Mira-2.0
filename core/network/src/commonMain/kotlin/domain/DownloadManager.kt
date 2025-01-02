package domain

interface DownloadManager {

    suspend fun download(url: String): ByteArray?
}