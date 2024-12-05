package com.example.ielts_application_pm.ui.screens.games.writing.components

import androidx.compose.runtime.Composable

@Composable
fun getSentenceGameData(): List<SentenceData> {
    return listOf(
        SentenceData(
            sentence = "I like cats very much",
            words = listOf("I", "like", "cats", "very", "much"),
        ),
        SentenceData(
            sentence = "The cat is sleeping",
            words = listOf("The", "cat", "is", "sleeping"),
        ),
        SentenceData(
            sentence = "I am learning Kotlin",
            words = listOf("I", "am", "learning", "Kotlin"),
        ),
        SentenceData(
            sentence = "She enjoys reading books",
            words = listOf("She", "enjoys", "reading", "books"),
        ),
        SentenceData(
            sentence = "We are going to the park",
            words = listOf("We", "are", "going", "to", "the", "park"),
        ),
        SentenceData(
            sentence = "They love playing football",
            words = listOf("They", "love", "playing", "football"),
        ),
        SentenceData(
            sentence = "He is cooking dinner",
            words = listOf("He", "is", "cooking", "dinner"),
        ),
        SentenceData(
            sentence = "This is a beautiful day",
            words = listOf("This", "is", "a", "beautiful", "day"),
        ),
        SentenceData(
            sentence = "Birds are flying in the sky",
            words = listOf("Birds", "are", "flying", "in", "the", "sky"),
        ),
        SentenceData(
            sentence = "The sun is shining brightly",
            words = listOf("The", "sun", "is", "shining", "brightly"),
        )
    )
}
