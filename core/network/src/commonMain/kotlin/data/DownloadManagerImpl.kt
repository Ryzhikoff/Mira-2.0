package data

import domain.DownloadManager
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DownloadManagerImpl : DownloadManager {

    private val client = HttpClient()

    /**
     *  @param url link for file download
     *
     *  @return ByteArray if success, null else failed
     */
    override suspend fun download(url: String): ByteArray? {
        return try {
            val response = client.get(url)
            if (response.status.value == 200) {
                response.body<ByteArray>()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}