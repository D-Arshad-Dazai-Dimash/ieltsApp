
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnswerInput(onSubmit: (String) -> Unit) {
    var answer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = answer,
            onValueChange = { answer = it },
            label = { Text("Введите, что вы услышали") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                onSubmit(answer)
                answer = "" // Очистить поле после отправки
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Отправить")
        }
    }
}
