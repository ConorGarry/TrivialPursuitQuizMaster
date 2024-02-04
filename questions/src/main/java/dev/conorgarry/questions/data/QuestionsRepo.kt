package dev.conorgarry.questions.data

import com.squareup.moshi.Moshi
import dev.conorgarry.coreandroid.di.FeatureScope
import dev.conorgarry.questions.api.QuestionApi
import dev.conorgarry.questions.models.ChatGptPrompt
import dev.conorgarry.questions.models.Message
import dev.conorgarry.questions.models.QuestionModel
import io.getstream.log.streamLog
import javax.inject.Inject

const val PROMPT_TEMPLATE =
    "Give me a trivial pursuit style question for topic: %s." +
        "I want the response in json format with 3 fields, 'question', 'answer', 'trivia'." +
        "Difficulty should be medium to very hard." +
        "If entertainment, make it culturally relevant to Ireland, UK, Europe," +
        "or if relevant to rest of world, make sure it's public domain mainstream knowledge."

@FeatureScope
class QuestionsRepo @Inject constructor(
    private val questionsApi: QuestionApi,
    private val moshi: Moshi,
) : IQuestionsRepo {

    override suspend fun questionForTopic(topic: String): Result<QuestionModel> =
        questionsApi.questionForTopic(
            ChatGptPrompt(listOf(Message(PROMPT_TEMPLATE.format(topic))))
        ).map {
            val content = it.choices.first().message.content
            streamLog { "content: $content" }
            // content is a json string of 'question', 'answer', 'trivia'
            moshi.adapter(QuestionModel::class.java).fromJson(content)!!
        }
}
