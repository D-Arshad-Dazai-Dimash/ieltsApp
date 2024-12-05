package com.example.ielts_application_pm.ui.screens.games.reading


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ielts_application_pm.R

@Composable
fun ReadingScreen(navController: NavController, stories: List<Story>) {
    var currentStoryIndex by remember { mutableStateOf(0) }
    val currentStory = stories[currentStoryIndex]

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }
    var correctCount by remember { mutableStateOf(0) }

    val currentQuestion = if (currentQuestionIndex < currentStory.questions.size) {
        currentStory.questions[currentQuestionIndex]
    } else null

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16172B))
            .padding(top = 60.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp , bottom = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                IconButton(onClick = {
                    val isPopped = navController.popBackStack()
                    if (!isPopped) {
                        navController.navigateUp()
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_arrow_back),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }

            if (!showResult) {
                Text(
                    text = "Story ${currentStoryIndex + 1}: ${currentStory.title}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.White
                )
                Text(
                    text = currentStory.content,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White
                )
            }

            // Question Section
            if (!showResult) {
                currentQuestion?.let { question ->
                    Text(
                        text = "Question ${currentQuestionIndex + 1}:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.White
                    )
                    Text(
                        text = question.text,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 16.dp),
                        color = Color.White
                    )

                    question.options.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = selectedAnswer == option,
                                onClick = { selectedAnswer = option }
                            )
                            Text(
                                text = option,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if (selectedAnswer == question.correctAnswer) correctCount++
                            if (currentQuestionIndex < currentStory.questions.size - 1) {
                                currentQuestionIndex++
                                selectedAnswer = null
                            } else {
                                showResult = true
                            }
                        },
                        enabled = selectedAnswer != null
                    ) {
                        Text(text = if (currentQuestionIndex < currentStory.questions.size - 1) "Next Question" else "Finish")
                    }
                }
            } else {
                // Result Section
                Text(
                    text = "Quiz Completed!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "You got $correctCount out of ${currentStory.questions.size} questions correct.",
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (currentStoryIndex < stories.size - 1) {
                    Button(onClick = {
                        currentStoryIndex++
                        currentQuestionIndex = 0
                        correctCount = 0
                        selectedAnswer = null
                        showResult = false
                    }) {
                        Text(text = "Next Story")
                    }
                } else {
                    Button(onClick = { navController.navigateUp() }) {
                        Text(text = "Back to Main Menu")
                    }
                }
            }
        }
    }
}

data class Story(
    val title: String,
    val content: String,
    val questions: List<Question>
)

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: String
)
