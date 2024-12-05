package com.example.ielts_application_pm.ui.screens.games.reading

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainReadingScreen(navController: NavController) {
    val stories = listOf(
        Story(
            title = "The Magical Forest",
            content = """
                Once upon a time, in a dense and magical forest, there was a hidden village called Eldoria. 
                The village was known for its enchanting beauty, vibrant wildlife, and the wisdom of its elders. 
                A young girl named Lyra lived in Eldoria and often wandered into the forest to discover its secrets.

                One day, Lyra found an ancient map buried under the roots of a giant oak tree. The map depicted a 
                path to a legendary treasure hidden deep within the forest. Driven by curiosity, she decided to 
                follow the map, encountering mystical creatures, riddles, and challenges along the way.

                After days of exploration, she reached a radiant clearing where the treasure was supposed to be. 
                Instead of gold and jewels, she found an ancient book glowing with light. When Lyra opened it, 
                she discovered that it was a book of infinite knowledge. The book revealed the secrets of the 
                forest and taught her to protect its magic. Lyra became the guardian of Eldoria, ensuring that 
                its wonders remained preserved for generations to come.
            """.trimIndent(),
            questions = listOf(
                Question(
                    text = "What was the name of the hidden village?",
                    options = listOf("Eldoria", "Eldorion", "Magical Forest", "Lyra's Village"),
                    correctAnswer = "Eldoria"
                ),
                Question(
                    text = "What did Lyra find buried under the oak tree?",
                    options = listOf("A treasure chest", "An ancient map", "A glowing book", "Jewels"),
                    correctAnswer = "An ancient map"
                )
            )
        ),
        Story(
            title = "The Brave Knight",
            content = """
                Long ago, in the kingdom of Avalon, a brave knight named Cedric was known for his courage and strength. 
                Cedric was tasked by the king to rescue a kidnapped princess from a ferocious dragon. He ventured 
                into the dark mountains, battling fierce creatures along the way.

                After days of travel, Cedric reached the dragon's lair. Using his wit and skill, he defeated the 
                dragon and saved the princess. The kingdom celebrated his heroic act, and Cedric became a symbol of hope and bravery.
            """.trimIndent(),
            questions = listOf(
                Question(
                    text = "What was the name of the knight?",
                    options = listOf("Cedric", "Arthur", "Gawain", "Lancelot"),
                    correctAnswer = "Cedric"
                ),
                Question(
                    text = "What was Cedric's mission?",
                    options = listOf(
                        "To find treasure",
                        "To defeat the king",
                        "To rescue the princess",
                        "To explore the dark mountains"
                    ),
                    correctAnswer = "To rescue the princess"
                )
            )
        )
    )

    ReadingScreen(navController = navController, stories = stories)
}
