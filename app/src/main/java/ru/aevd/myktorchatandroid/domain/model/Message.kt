package ru.aevd.myktorchatandroid.domain.model

data class Message(
    val text: String,
    val formattedTime: String,
    val username: String
)
