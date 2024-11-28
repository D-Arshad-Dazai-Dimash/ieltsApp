package com.example.ielts_application_pm.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ielts_application_pm.R

@Composable
fun AppBottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Listening", "listening", painterResource(R.drawable.listening_icon)),
        BottomNavItem("Writing", "writing", painterResource(R.drawable.writing_icon)),
        BottomNavItem("Reading", "reading", painterResource(R.drawable.reading_icon)),
        BottomNavItem("Speaking", "speaking", painterResource(R.drawable.user_speak_svgrepo_com))
    )

    NavigationBar( containerColor = Color(0xFF313131)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                colors = NavigationBarItemColors(
                    selectedTextColor = Color.White,
                    selectedIconColor = Color(0xFF313131),
                    selectedIndicatorColor = Color.White,
                    unselectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    disabledIconColor = Color.White,
                    disabledTextColor = Color.White
                ),
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = false
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: Painter
)
