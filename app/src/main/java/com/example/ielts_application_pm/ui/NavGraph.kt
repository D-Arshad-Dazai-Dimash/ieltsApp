package com.example.ielts_application_pm.ui

import TaskDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ielts_application_pm.ui.screens.TaskListScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "listening") {
        composable("listening") { TaskListScreen("Listening", navController,  modifier) }
        composable("writing") { TaskListScreen("Writing", navController , modifier) }
        composable("reading") { TaskListScreen("Reading",navController ,  modifier) }
        composable("speaking") { TaskListScreen("Speaking",  navController, modifier) }

        composable("taskDetail/{taskTitle}") { backStackEntry ->
            val taskTitle = backStackEntry.arguments?.getString("taskTitle") ?: ""
            TaskDetailScreen(taskTitle , navController)
        }
    }
}