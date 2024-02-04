package dev.conorgarry.questions.models

import com.squareup.moshi.Json

data class ChatGptResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "object")
    val `object`: String,
    @Json(name = "created")
    val created: Long,
    @Json(name = "model")
    val model: String,
    @Json(name = "usage")
    val usage: Usage,
    @Json(name = "choices")
    val choices: List<Choice>,
)

data class Usage(
    @Json(name = "prompt_tokens")
    val promptTokens: Int,
    @Json(name = "completion_tokens")
    val completionTokens: Int,
    @Json(name = "total_tokens")
    val totalTokens: Int,
)

data class Choice(
    @Json(name = "message")
    val message: Message,
    @Json(name = "finish_reason")
    val finishReason: String,
    @Json(name = "index")
    val index: Int,
)

data class Message(
    @Json(name = "content")
    val content: String,
    @Json(name = "role")
    val role: String = "user",
)

