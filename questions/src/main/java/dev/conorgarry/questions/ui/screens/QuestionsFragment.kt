package dev.conorgarry.questions.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dev.conorgarry.questions.data.IQuestionsRepo
import dev.conorgarry.questions.ui.QuestionsViewModel
import ie.conorgarry.androidcommon.extensions.fragmentViewModels
import javax.inject.Inject

class QuestionsFragment @Inject constructor(private val repo: IQuestionsRepo) : Fragment() {

    private val viewModel by fragmentViewModels {
        QuestionsViewModel(repo)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        ComposeView(requireContext()).apply {
            setContent {
                QuestionsScreen(viewModel)
            }
        }

    override fun onDestroy() {
        parentFragmentManager.fragmentFactory = FragmentFactory() // Resets to default.
        super.onDestroy()
    }
}

/**
 * TODO:
 *  Add Composable previews.
 *  Resource handling instead of String literals.
 *  Either use or remove AppBar.
 *  Remove showQuestionSelection and only use states for UI.
 *  Background design.
 *  UI design for question menu and Answer Card.
 */
