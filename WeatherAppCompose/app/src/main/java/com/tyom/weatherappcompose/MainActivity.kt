package com.tyom.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tyom.weatherappcompose.ui.theme.Blue1
import com.tyom.weatherappcompose.ui.theme.Purple1
import com.tyom.weatherappcompose.ui.theme.Purple80
import com.tyom.weatherappcompose.ui.theme.WeatherAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Preview
@Composable
fun Greeting() {
    Column (modifier = Modifier.fillMaxSize()){
        Box (modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(color = Blue1),
            contentAlignment = Alignment.Center){
            Text(text = "Hello weather!", color = Color.White, fontSize = 25.sp)
        }
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Purple1),
            contentAlignment = Alignment.BottomCenter){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()) {
                Text(text = "Refresh", fontSize = 20.sp)
            }
        }
    }
}

