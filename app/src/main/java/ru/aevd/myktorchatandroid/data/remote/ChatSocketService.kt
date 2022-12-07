package ru.aevd.myktorchatandroid.data.remote

import kotlinx.coroutines.flow.Flow
import ru.aevd.myktorchatandroid.domain.model.Message
import ru.aevd.myktorchatandroid.util.Resource

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        //TODO: replace with local ip (phone, emulator)
        const val BASE_URL = "ws://192.168.0.104:8080"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket: Endpoints("$BASE_URL/chat-socket")
    }
}