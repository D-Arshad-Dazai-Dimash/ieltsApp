package com.example.ielts_application_pm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ielts_application_pm.theme.IELTS_APPLICATION_PM_THEME
import com.example.ielts_application_pm.ui.NavigationGraph
import com.example.ielts_application_pm.ui.components.AppBottomNavigation
import com.example.ielts_application_pm.ui.components.AppDrawer
import com.example.ielts_application_pm.ui.components.AppTopBar
import com.example.ielts_application_pm.ui.components.currentRoute
import kotlinx.coroutines.launch

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

@Preview(showBackground = true)
@Composable
fun LanguageApp() {
    val navController = rememberNavController()
    val drawerState =
        rememberDrawerState(initialValue = androidx.compose.material3.DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer { route ->
                coroutineScope.launch {
                    drawerState.close()
                }
                navController.navigate(route)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF79B473)),
        ) {
            val currentRoute = currentRoute(navController)

            val mainRoutes = listOf("listening", "writing", "reading", "speaking")
            val showAppBars = mainRoutes.contains(currentRoute)

            Log.d("LanguageApp", "Current route: $currentRoute, Show AppBars: $showAppBars")

            Scaffold(
                topBar = {
                    if (showAppBars) {
                        AppTopBar(
                            onMenuClicked = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            },
                        )
                    }
                },
                bottomBar = {
                    if (showAppBars) {
                        AppBottomNavigation(navController)
                    }
                },
            ) { innerPadding ->
                NavigationGraph(navController, Modifier.padding(innerPadding))
            }
        }
    }
}
