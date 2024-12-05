package com.example.ielts_application_pm.ui

import TaskDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ielts_application_pm.ui.screens.AboutPage
import com.example.ielts_application_pm.ui.screens.NotificationsScreen
import com.example.ielts_application_pm.ui.screens.ProfileScreen
import com.example.ielts_application_pm.ui.screens.ProgressPageScreen
import com.example.ielts_application_pm.ui.screens.ScoreboardScreen
import com.example.ielts_application_pm.ui.screens.SettingPageScreen
import com.example.ielts_application_pm.ui.screens.SupportPage
import com.example.ielts_application_pm.ui.screens.TaskListScreen
import com.example.ielts_application_pm.ui.screens.VocabularyPageScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "listening") {
        composable("listening") { TaskListScreen("Listening", navController, modifier) }
        composable("writing") { TaskListScreen("Writing", navController, modifier) }
        composable("reading") { TaskListScreen("Reading", navController, modifier) }
        composable("speaking") { TaskListScreen("Speaking", navController, modifier) }
        composable("profile") { ProfileScreen(navController) }
        composable("vocabulary") { VocabularyPageScreen(navController) }
        composable("progress") { ProgressPageScreen(navController) }
        composable("scoreboard") { ScoreboardScreen(navController) }
        composable("notifications") { NotificationsScreen(navController) }
        composable("settings") { SettingPageScreen(navController) }
        composable("support") { SupportPage(navController) }
        composable("about") { AboutPage(navController) }
        composable("taskDetail/{taskTitle}") { backStackEntry ->
            val taskTitle = backStackEntry.arguments?.getString("taskTitle") ?: ""
            TaskDetailScreen(taskTitle, navController)
        }
    }
}