package ru.aevd.myktorchatandroid.data.remote

import android.util.Log
import io.ktor.client.*
import io.ktor.client.request.*
import ru.aevd.myktorchatandroid.data.remote.dto.MessageDto
import ru.aevd.myktorchatandroid.domain.model.Message

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
                .map {it.toMessage() }
        } catch (e: Exception) {
            Log.d("MessageServiceImpl", "error getting all messages")
            e.printStackTrace()
            return emptyList()
        }
    }
}