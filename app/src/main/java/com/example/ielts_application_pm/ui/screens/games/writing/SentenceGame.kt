package com.example.ielts_application_pm.ui.screens.games.writing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ielts_application_pm.R
import com.example.ielts_application_pm.ui.screens.games.writing.components.getSentenceGameData
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun SentenceGame(navController: NavController) {
    val sentences = getSentenceGameData()
    var currentSentenceIndex by remember { mutableStateOf(0) }
    val currentSentence = sentences[currentSentenceIndex]

    val shuffledWords = currentSentence.words.shuffled()
    var userAnswer by remember { mutableStateOf(listOf<String>()) }
    var remainingWords by remember { mutableStateOf(shuffledWords) }
    var currentImageRes by remember { mutableStateOf(currentSentence.thinkingImage) }
    var isAnswerChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF070F2B))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, top = 50.dp)
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

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = currentImageRes),
            contentDescription = "Status Image",
            modifier = Modifier
                .size(150.dp)
                .background(color = Color.White, shape = RoundedCornerShape(50.dp))
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = userAnswer.joinToString(" "),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            remainingWords.forEach { word ->
                Button(
                    onClick = {
                        userAnswer = userAnswer + word
                        remainingWords = remainingWords - word
                    },
                    modifier = Modifier.padding(4.dp),
                    colors = ButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.White
                    )
                ) {
                    Text(
                        text = word,
                        color = Color(0xFF000000),
                        fontWeight = W600
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (!isAnswerChecked) {
            Button(
                onClick = {
                    if (userAnswer.joinToString(" ") == currentSentence.sentence) {
                        userAnswer = listOf("🎉 Correct!")
                        currentImageRes = currentSentence.correctImage
                    } else {
                        userAnswer = listOf("❌ Incorrect!")
                        currentImageRes = currentSentence.incorrectImage
                    }
                    isAnswerChecked = true
                },
                enabled = remainingWords.isEmpty(),
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.White
                )
            ) {
                Text(
                    text = "Check",
                    color = Color.Black,
                    fontWeight = W600
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isAnswerChecked) {
            Button(
                onClick = {
                    if (currentSentenceIndex < sentences.size - 1) {
                        currentSentenceIndex++
                        val nextSentence = sentences[currentSentenceIndex]
                        userAnswer = listOf()
                        remainingWords = nextSentence.words.shuffled()
                        currentImageRes = nextSentence.thinkingImage
                        isAnswerChecked = false
                    }
                },
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.White
                )
            ) {
                Text(
                    text = "Next",
                    color = Color.Black,
                    fontWeight = W600
                )
            }
        }


        Button(
            onClick = {
                userAnswer = listOf()
                remainingWords = shuffledWords
                currentImageRes = currentSentence.thinkingImage
                isAnswerChecked = false
            },
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.White
            )
        ) {
            Text(
                text = "Clear", color = Color.Black,
                fontWeight = W600
            )
        }
    }
}

