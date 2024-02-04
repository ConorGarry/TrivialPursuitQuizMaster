package dev.conorgarry.questions.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import dev.conorgarry.questions.models.Topic
import dev.conorgarry.questions.ui.QuestionsViewModel

@Composable
fun TopicMenu(
    showTopicSelection: MutableState<Boolean>,
    vm: QuestionsViewModel
) {
    val purple = Color(0xFF9C27B0)
    val orange = Color(0xFFFF9800)
    val pink = Color(0xFFE91E63)
    Dialog(onDismissRequest = { showTopicSelection.value = false }) {
        Card {
            Column(
                Modifier
                    .background(Color.LightGray)
                    .padding(8.dp)
            ) {
                Topic.entries.forEach { topic ->
                    val bgColor =
                        when (topic) {
                            Topic.Entertainment -> pink
                            Topic.ArtsAndLiterature -> purple
                            Topic.SportsAndLeisure -> orange
                            Topic.Geography -> Color.Blue
                            Topic.History -> Color.Yellow
                            Topic.ScienceAndNature -> Color.Green
                        }
                    Button(
                        onClick = {
                            showTopicSelection.value = false
                            // TODO: Hide answer before new question as it still shows.
                            vm.questionForTopic(topic)
                        },
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.buttonColors(containerColor = bgColor),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(topic.topic, color = Color.Black)
                    }
                }
            }
        }
    }
}
