package dev.conorgarry.questions.di

import androidx.fragment.app.FragmentFactory
import dev.conorgarry.questions.ui.screens.QuestionsFragment
import javax.inject.Inject
import javax.inject.Provider

class QuestionsFragmentFactory @Inject constructor(
    private val questionsFragmentFactory: Provider<QuestionsFragment>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (loadFragmentClass(classLoader, className)) {
            QuestionsFragment::class.java -> questionsFragmentFactory.get()
            else -> super.instantiate(classLoader, className)
        }
}
