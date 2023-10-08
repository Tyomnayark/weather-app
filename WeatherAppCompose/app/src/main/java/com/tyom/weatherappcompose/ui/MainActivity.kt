package com.tyom.weatherappcompose.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.tyom.weatherappcompose.ui.theme.Blue1
import com.tyom.weatherappcompose.ui.theme.Purple1
import com.tyom.weatherappcompose.ui.theme.WeatherAppComposeTheme
import com.tyom.weatherappcompose.viewmodel.MainActivityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainActivityViewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)

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
fun Greeting( ) {
    val viewModel: MainActivityViewModel = viewModel()

    Column (modifier = Modifier.fillMaxSize()){

        val temperature = remember { mutableStateOf("0") }
        val town = remember { mutableStateOf("Astana") }

        viewModel.temperature.observeAsState().value?.let {
            temperature.value = it
        }

        viewModel.town.observeAsState().value?.let {
            town.value = it
        }


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

            Text(text = temperature.value, color = Color.White, fontSize = 25.sp)

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()) {
                Text(text = "Refresh", fontSize = 20.sp)
            }
        }

    }
}


