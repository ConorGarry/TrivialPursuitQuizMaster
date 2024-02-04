package dev.conorgarry.questions.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AnswerCard(
    answer: String,
    trivia: String,
) {
    var reveal by remember { mutableStateOf(false) }

    Card(modifier = Modifier.padding(8.dp)) {
        Box(
            Modifier.clickable { reveal = !reveal }
        ) {
            // Hide or show text based on reveal state.
            if (reveal) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = answer)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = trivia)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            } else {
                TextButton(onClick = { reveal = !reveal }) {
                    Text(
                        text = "Click to reveal answer.",
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}
