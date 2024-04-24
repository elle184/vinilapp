package edu.co.grupo4.vinilapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.co.grupo4.vinilapp.ui.theme.VinilAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinilAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitialMenu()
                }
            }
        }
    }
}

@Composable
fun MusicCollector(modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.collector)
    
    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun Visitor(modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.guest)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun InitialMenu(modifier : Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center
        , modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
            , modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            MusicCollector(modifier = Modifier.padding(end = 30.dp))
            Visitor(modifier = Modifier.padding(start = 30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VinilAppTheme {
        InitialMenu()
    }
}