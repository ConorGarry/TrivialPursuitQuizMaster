package dev.conorgarry.questions.ui

import UiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.conorgarry.questions.data.IQuestionsRepo
import dev.conorgarry.questions.models.QuestionModel
import dev.conorgarry.questions.models.Topic
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import toUiState

class QuestionsViewModel(
    private val repo: IQuestionsRepo,
    private val dispatchers: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<QuestionModel>>(UiState.None)
    val uiState: StateFlow<UiState<QuestionModel>> = _uiState.asStateFlow()

    fun reset() {
        _uiState.value = UiState.None
    }

    fun questionForTopic(topic: Topic) {
        _uiState.value = UiState.Loading
        viewModelScope.launch(dispatchers) {
            _uiState.postValue(
                repo.questionForTopic(topic.topic)
                    .onFailure(Throwable::printStackTrace)
                    .toUiState()
            )
        }
    }

    /**
     * Essentially a `postValue` for MutableStateFlow, based on the same flow in LiveData.
     * TODO: Move to a common module.
     */
    suspend fun <T> MutableStateFlow<T>.postValue(newValue: T, immediate: Boolean = false) {
        withContext(if (immediate) Dispatchers.Main.immediate else Dispatchers.Main) {
            value = newValue
        }
    }
}
