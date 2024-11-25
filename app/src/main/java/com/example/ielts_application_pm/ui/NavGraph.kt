package com.example.ielts_application_pm.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ielts_application_pm.ui.screens.TaskListScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "listening") {
        composable("listening") { TaskListScreen("Listening", modifier) }
        composable("writing") { TaskListScreen("Writing", modifier) }
        composable("reading") { TaskListScreen("Reading", modifier) }
        composable("speaking") { TaskListScreen("Speaking", modifier) }
    }
}