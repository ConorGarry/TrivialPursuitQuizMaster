package dev.conorgarry.questions.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dev.conorgarry.coreandroid.di.FeatureScope
import dev.conorgarry.questions.api.QuestionApi
import dev.conorgarry.questions.data.IQuestionsRepo
import dev.conorgarry.questions.data.QuestionsRepo
import retrofit2.Retrofit

@Suppress("unused") // @Binds function only used in Dagger graph.
@Module
interface QuestionsModule {

    companion object {
        @Provides
        @FeatureScope
        fun provideChatGPTService(retrofit: Retrofit): QuestionApi =
            retrofit.create(QuestionApi::class.java)
    }

    @Binds
    fun bindQuestionsRepo(questionsRepo: QuestionsRepo): IQuestionsRepo
}
