package com.example.myapplication // <-- keep your package

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(Modifier.fillMaxSize()) {
                    HelloScreen()
                }
            }
        }
    }
}

@Composable
fun HelloScreen() {
    // TODO: put YOUR info here
    val myName  = "Jinpeng Huang"
    val myEmail = "jinpeng@bu.edu"

    var message by remember { mutableStateOf("Hello Android!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$myName\n$myEmail", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        Text(text = message, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            message = if (message.startsWith("Hello"))
                "Hi from $myName!"
            else
                "Hello Android!"
        }) {
            Text("Change message")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    MyApplicationTheme { HelloScreen() }
}
