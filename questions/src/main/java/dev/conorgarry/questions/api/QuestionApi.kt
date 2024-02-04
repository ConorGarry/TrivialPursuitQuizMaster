package dev.conorgarry.questions.api

import dev.conorgarry.questions.models.ChatGptPrompt
import dev.conorgarry.questions.models.ChatGptResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface QuestionApi {
    @POST("chat/completions")
    suspend fun questionForTopic(@Body topic: ChatGptPrompt): Result<ChatGptResponse>
}
