package dev.conorgarry.questions.di

import com.squareup.moshi.Moshi
import dagger.Component
import dev.conorgarry.coreandroid.di.CoreComponent
import dev.conorgarry.coreandroid.di.FeatureScope
import dev.conorgarry.questions.api.QuestionApi
import dev.conorgarry.questions.data.IQuestionsRepo

@FeatureScope
@Component(modules = [QuestionsModule::class], dependencies = [CoreComponent::class])
interface QuestionsComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): QuestionsComponent
    }

    fun questionsRepository(): IQuestionsRepo

    fun questionService(): QuestionApi

    fun moshi(): Moshi

    fun retrofit(): Moshi

    fun fragmentFactory(): QuestionsFragmentFactory
}
