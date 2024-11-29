package com.example.ielts_application_pm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ielts_application_pm.ui.screens.components.TaskCard

@Composable
fun TaskListScreen(title: String, navController: NavHostController, modifier: Modifier = Modifier) {
    val tasks = when (title) {
        "Listening" -> listOf(
            "Listen, Scroll, Answer" to "Listen the phrase and write sown the phrase",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
            "The Game" to "Description of Listening game",
        )

        "Writing" -> listOf(
            "Grammar" to "Put words in the correct order",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
            "GAME" to "Description of Writing game",
        )

        "Reading" -> listOf(
            "The cat tells a story" to "You can pet the cat and cat tells a story for you",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",
            "GAME" to "Description of Reading game",


            )

        "Speaking" -> listOf(
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
        )

        else -> emptyList()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
//                Text(
//                    text = "$title Tasks",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(8.dp),
//                    color = Color.White
//                )
                Spacer(modifier = Modifier.padding(30.dp))
            }

            items(tasks.size) { index ->
                val (taskTitle, taskDescription) = tasks[index]
                TaskCard(
                    title = taskTitle,
                    description = taskDescription,
                    onClick = { navController.navigate("taskDetail/$taskTitle") }
                )
            }
        }

    }
}
