package com.example.ielts_application_pm.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onMenuClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "         IELTS APP            ",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 30.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { onMenuClicked() }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
        },
        colors = TopAppBarColors(
            containerColor = Color(0xFF16172B),
            titleContentColor = Color(0xFF16172B),
            navigationIconContentColor = Color(0xFF16172B),
            scrolledContainerColor = Color(0xFF16172B),
            actionIconContentColor = Color(0xFF16172B)
        ),
        modifier = Modifier.clip(RoundedCornerShape(8.dp))
    )
}
