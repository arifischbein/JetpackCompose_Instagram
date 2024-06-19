package com.example.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeinstagram.login.ui.LoginScreen
import com.example.jetpackcomposeinstagram.login.ui.LoginViewModel
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeInstagramTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
//                    containerColor = Color.Transparent
                ) { innerPadding ->
                    LoginScreen(Modifier.padding(innerPadding), LoginViewModel())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeInstagramTheme {
    }
}
