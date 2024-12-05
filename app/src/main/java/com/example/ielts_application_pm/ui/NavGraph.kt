package com.example.ielts_application_pm.ui

import TaskDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ielts_application_pm.ui.screens.menu.AboutPage
import com.example.ielts_application_pm.ui.screens.menu.NotificationsScreen
import com.example.ielts_application_pm.ui.screens.menu.ProfileScreen
import com.example.ielts_application_pm.ui.screens.menu.ProgressPageScreen
import com.example.ielts_application_pm.ui.screens.menu.ScoreboardScreen
import com.example.ielts_application_pm.ui.screens.menu.SettingPageScreen
import com.example.ielts_application_pm.ui.screens.menu.SupportPage
import com.example.ielts_application_pm.ui.screens.TaskListScreen
import com.example.ielts_application_pm.ui.screens.games.reading.MainReadingScreen
import com.example.ielts_application_pm.ui.screens.games.writing.SentenceGame
import com.example.ielts_application_pm.ui.screens.menu.VocabularyPageScreen
import com.example.tt.GameScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "listening") {
        // MENU
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

        //TaskDetail
        composable("taskDetail/{taskTitle}") { backStackEntry ->
            val taskTitle = backStackEntry.arguments?.getString("taskTitle") ?: ""
            TaskDetailScreen(taskTitle, navController)
        }

        //
        composable("Listen, Scroll, Answer") {
            GameScreen(navController)
        }
        composable("grammar") {
            SentenceGame(navController)
        }
        composable("read and answer") {
            MainReadingScreen(navController)
        }
    }
}