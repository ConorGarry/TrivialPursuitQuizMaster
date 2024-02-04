package dev.conorgarry.questions.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.conorgarry.questions.models.QuestionModel
import dev.conorgarry.questions.ui.QuestionsViewModel
import dev.conorgarry.questions.ui.components.AnswerCard
import dev.conorgarry.questions.ui.components.TopicMenu

@Composable
fun QuestionsScreen(vm: QuestionsViewModel) {
    val showTopicSelection = remember { mutableStateOf(true) }
    val uiState = vm.uiState.collectAsState(UiState.None)
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        when (uiState.value) {
            UiState.Loading ->
                CircularProgressIndicator()
            is UiState.Success -> {
                with((uiState.value as UiState.Success<QuestionModel>).data) {
                    Card(
                        modifier =
                        Modifier
                            .padding(8.dp)
                            .clickable {
                                showTopicSelection.value = false
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = question)
                            Spacer(modifier = Modifier.height(8.dp))
                            AnswerCard(answer = answer, trivia = trivia)
                            Button(
                                onClick = {
                                    showTopicSelection.value = true
                                    vm.reset()
                                },
                                Modifier.align(Alignment.End),
                            ) {
                                Text(text = "Select Topic")
                            }
                        }
                    }
                }
            }

            is UiState.Error -> {
                val error = (uiState.value as UiState.Error).exception
                AlertDialog(
                    onDismissRequest = {},
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showTopicSelection.value = true
                                vm.reset()
                            }
                        ) {
                            Text(text = "Retry")
                        }
                    },
                    title = { Text("Error") },
                    text = { Text("Error: ${error.message}") }
                )
            }

            UiState.None ->
                if (showTopicSelection.value) {
                    TopicMenu(showTopicSelection, vm)
                }
        }
    }
    /*LaunchedEffect(true) { // Not required?, but good reminder of launch task.
        vm.questionForTopic(Topic.Entertainment)
    }*/
}
