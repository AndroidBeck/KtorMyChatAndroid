package ru.aevd.myktorchatandroid.data.remote

import ru.aevd.myktorchatandroid.domain.model.Message

interface MessageService {
    suspend fun getAllMessages(): List<Message>

    companion object {
        //TODO: replace with local ip (phone, emulator)
        const val BASE_URL = "http://192.168.0.104:8080"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("$BASE_URL/messages")
    }
}