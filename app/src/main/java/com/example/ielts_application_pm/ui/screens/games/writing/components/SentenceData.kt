package com.example.ielts_application_pm.ui.screens.games.writing.components

import com.example.ielts_application_pm.R

data class SentenceData(
    val sentence: String,
    val words: List<String>,
    val thinkingImage: Int = R.drawable.thinking_image,
    val correctImage: Int = R.drawable.`fun`,
    val incorrectImage: Int = R.drawable.sad
)
