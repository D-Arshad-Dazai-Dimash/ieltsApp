package com.example.ielts_application_pm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ielts_application_pm.theme.IELTS_APPLICATION_PM_THEME
import com.example.ielts_application_pm.ui.NavigationGraph
import com.example.ielts_application_pm.ui.components.AppBottomNavigation
import com.example.ielts_application_pm.ui.components.AppTopBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IELTS_APPLICATION_PM_THEME {
                LanguageApp()
            }
        }
    }
}

@Composable
fun LanguageApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomNavigation(navController) }
    ) { innerPadding ->
        NavigationGraph(navController, Modifier.padding(innerPadding))
    }
}

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import com.example.project_modile_application.presentation.navigation.MainComposable
//import com.example.project_modile_application.presentation.ui.screen.filmography.FilmographyScreen
//import com.example.ielts_application_pm.theme.Project_Modile_ApplicationTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Project_Modile_ApplicationTheme {
//                MainComposable()
//            }
//        }
//    }
//}