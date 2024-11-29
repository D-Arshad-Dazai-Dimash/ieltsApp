package com.example.ielts_application_pm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ielts_application_pm.R

@Composable
fun AppDrawer(onItemSelected: (String) -> Unit) {
    ModalDrawerSheet(drawerContainerColor = Color(0xFFF1E3E4)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.cats_logo),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(160.dp)
                    .padding(bottom = 8.dp)
                    .clip(RoundedCornerShape(160.dp))
            )
            Text(
                text = "nazzy 💖",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 4.dp),
                color = Color.Black,
                fontWeight = W700
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            DrawerMenuItem(
                icon = Icons.Default.Person,
                text = "My Profile",
                onClick = { onItemSelected("profile") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Create,
                text = "Vocabulary",
                onClick = { onItemSelected("vocabulary") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Check,
                text = "Progress",
                onClick = { onItemSelected("progress") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Star,
                text = "Scoreboard",
                onClick = { onItemSelected("scoreboard") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Notifications,
                text = "Notifications",
                onClick = { onItemSelected("notifications") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Settings,
                text = "Settings",
                onClick = { onItemSelected("settings") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Email,
                text = "Support",
                onClick = { onItemSelected("support") }
            )
            DrawerMenuItem(
                icon = Icons.Default.Info,
                text = "About",
                onClick = { onItemSelected("about") }
            )
        }
    }
}

@Composable
fun DrawerMenuItem(icon: ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
            .background(Color(0xFFF1E3E4)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = W700
        )
    }
}
