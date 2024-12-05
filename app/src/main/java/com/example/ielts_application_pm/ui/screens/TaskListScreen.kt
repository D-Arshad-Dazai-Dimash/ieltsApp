package com.example.ielts_application_pm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ielts_application_pm.ui.screens.components.TaskCard

@Composable
fun TaskListScreen(title: String, navController: NavHostController, modifier: Modifier = Modifier) {
    val tasks = when (title) {
        "Listening" -> listOf(
            "Listen, Scroll, Answer" to "Listen the phrase and write sown the phrase",
            "Game 1 " to "Description of Listening game",
            "Game 2" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
//            "The Game" to "Description of Listening game",
        )

        "Writing" -> listOf(
            "Grammar" to "Put words in the correct order",
            "GAME 1" to "Description of Writing game",
            "GAME 2" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
//            "GAME" to "Description of Writing game",
        )

        "Reading" -> listOf(
            "The cat tells a story" to "You can pet the cat and cat tells a story for you",
            "GAME" to "Description of Reading game",
            "Read and Answer" to "Read the story and answer to the questions",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",
//            "GAME" to "Description of Reading game",


            )

        "Speaking" -> listOf(
            "The Game" to "Description of Speaking game",
            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
//            "The Game" to "Description of Speaking game",
        )

        else -> emptyList()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF16172B))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp)
                .background(color = Color(0xFF16172B)),
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
                    onClick = {
                        if (taskTitle.equals("Listen, Scroll, Answer")) {
                            navController.navigate("Listen, Scroll, Answer")
                        } else if (taskTitle.equals("Grammar")) {
                            navController.navigate("grammar")
                        }else if(taskTitle.equals("Read and Answer")) {
                            navController.navigate("read and answer")
                        } else {
                            navController.navigate("taskDetail/$taskTitle")
                        }
                    }
                )
            }
        }

    }
}
