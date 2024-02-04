package dev.conorgarry.questions.models

import com.squareup.moshi.Json

data class ChatGptPrompt(
    @Json(name = "messages")
    val messages: List<Message>,
    @Json(name = "model")
    val model: String = "gpt-3.5-turbo-16k",
)


