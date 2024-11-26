package com.example.ielts_application_pm.ui.screens.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskList(tasks: List<Pair<String, String>>, onItemClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(tasks.size) { index ->
            val (title, description) = tasks[index]
            TaskCard(
                title = title,
                description = description,
                onClick = { onItemClick(title) }
            )
        }
    }
}
