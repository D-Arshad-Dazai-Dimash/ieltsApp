package com.example.tt

import AnswerInput
import GameViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ielts_application_pm.R
import com.example.ielts_application_pm.ui.screens.games.listening.VideoPlayer

@JvmOverloads
@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel = viewModel()) {
    val currentVideo by viewModel.currentVideo.collectAsState()
    val isVideoPlaying by viewModel.isVideoPlaying.collectAsState()
    val correctAnswer by viewModel.correctAnswer
    val userAnswer by viewModel.userAnswer

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF16172B))
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

        if (isVideoPlaying) {
            VideoPlayer(uri = currentVideo) {
                viewModel.onVideoEnd()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (userAnswer == null) {
                    AnswerInput { answer ->
                        viewModel.onSubmitAnswer(answer)
                    }
                } else {
                    Text(
                        text = "Ваш ответ: $userAnswer",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Правильный ответ: $correctAnswer",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = { viewModel.nextVideo() }) {
                        Text("Следующее видео")
                    }
                }
            }
        }
    }
}
