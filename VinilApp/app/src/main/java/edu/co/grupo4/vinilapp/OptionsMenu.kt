package edu.co.grupo4.vinilapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.co.grupo4.vinilapp.ui.theme.VinilAppTheme


class OptionsMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinilAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Album(
    modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.album)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun artista(
    modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.artistas)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun coleccionistas(
    modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.coleccionista)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun ImageWithNavigationOptionsMenu(painter : Painter, onClick : () -> Unit) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
            .clickable { onClick() }
            .padding(8.dp),
        alignment = Alignment.Center,
        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewOptionsMenu() {
    VinilAppTheme {
        Home()
    }
}