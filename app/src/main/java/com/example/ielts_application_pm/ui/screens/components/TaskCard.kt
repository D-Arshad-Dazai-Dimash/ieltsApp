package com.example.ielts_application_pm.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun PrevTask() {
    TaskCard("Task 1 ", "Game", onClick = {})
}

@Composable
fun TaskCard(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp , start = 12.dp , end = 12.dp, bottom = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardColors(
            contentColor = Color(0xFF34346A),
            containerColor = Color(0xFF34346A),
            disabledContentColor = Color(0xFF34346A),
            disabledContainerColor = Color(0xFF34346A)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp , start = 20.dp , bottom = 2.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp),
                color = Color.White
            )
            Text(
                text = description,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color.White
            )
        }
    }
}
