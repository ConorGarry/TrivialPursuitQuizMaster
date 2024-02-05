package dev.conorgarry.questions.ui.screens

import UiState
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dev.conorgarry.questions.R
import dev.conorgarry.questions.models.QuestionModel
import dev.conorgarry.questions.models.Topic
import dev.conorgarry.questions.ui.QuestionsViewModel
import dev.conorgarry.questions.ui.components.AnswerCard
import dev.conorgarry.questions.ui.components.TopicMenu
import kotlin.math.max

val TpBlue = Color(0xFF2196F3)

@Composable
fun QuestionsScreen(vm: QuestionsViewModel) {
    val showTopicSelection = remember { mutableStateOf(true) }
    val uiState = vm.uiState.collectAsState(UiState.None)
    Box(
        Modifier
            .fillMaxSize()
            .background(
                object : ShaderBrush() {
                    override fun createShader(size: Size): Shader =
                        RadialGradientShader(
                            center = Offset(size.width / 2, size.height / 2),
                            radius = max(size.width, size.height) / 2,
                            colors = listOf(Color.White, TpBlue),
                            colorStops = listOf(0f, 0.95f)
                        )
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        DrawBackgroundIcons()

        // Stateful Content.
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
@Composable
fun DrawBackgroundIcons() {
    @Composable
    fun Int.toPainter() = rememberVectorPainter(ImageVector.vectorResource(this))
    val painterMap: Map<Topic, Painter> = mapOf(
        Topic.ArtsAndLiterature to R.drawable.ic_book.toPainter(),
        Topic.Entertainment to R.drawable.ic_theatre.toPainter(),
        Topic.History to R.drawable.ic_history.toPainter(),
        Topic.ScienceAndNature to R.drawable.ic_science.toPainter(),
        Topic.SportsAndLeisure to R.drawable.ic_sports.toPainter(),
        Topic.Geography to R.drawable.ic_map.toPainter()
    )
    val iconSize = Size(250f, 250f)
    val alpha = 0.25f

    Canvas(modifier = Modifier.fillMaxSize()) {
        listOf(
            size.width / 9 to size.height / 9,
            size.width / 2.5f to size.height / 16,
            size.width / 1.35f to size.height / 9,
            size.width / 9 to size.height * 0.75f,
            size.width / 2.5f to size.height * 0.85f,
            size.width / 1.35f to size.height * 0.75f
        ).forEachIndexed { i, (l, t) ->
            Topic.entries[i].let { topic ->
                translate(l, t) {
                    with(painterMap[topic]!!) {
                        draw(iconSize, alpha, ColorFilter.tint(Color.White))
                    }
                }
            }
        }
    }
}
