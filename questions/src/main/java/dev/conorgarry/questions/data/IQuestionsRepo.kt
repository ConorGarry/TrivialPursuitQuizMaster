package dev.conorgarry.questions.data

import dev.conorgarry.questions.models.QuestionModel

interface IQuestionsRepo {
    suspend fun questionForTopic(topic: String): Result<QuestionModel>
}
