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
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "MainActivity") {
        composable("MainActivity") { InitialMenu(navController) }
        composable("OptionsMenu") { OptionsMenu() }
    }
}

@Composable
fun MusicCollector(
    modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.collector)
    
    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun Visitor(
    modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.guest)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@Composable
fun Header(modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.logo_vinilapp)

    Box(modifier) {
        Image(
            painter = image
            , contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialMenu(
    navController : NavHostController
    , modifier : Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                    , titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = "VinilApp"
                        , style = MaterialTheme.typography.bodyLarge)
                }, navigationIcon = {
                    Header(modifier = Modifier.size(60.dp))
                }
            )
        }
    ) {
        innerPadding -> Column(
            modifier = Modifier.padding(innerPadding)
            , verticalArrangement = Arrangement.Center
        ) {
            Column (
                verticalArrangement = Arrangement.Center
                , modifier = modifier
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                    , modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    ImageWithNavigation(
                        painter = painterResource(id = R.drawable.collector)
                        , onClick = { navController.navigate("OptionsMenu") })
                    ImageWithNavigation(
                        painter = painterResource(id = R.drawable.guest)
                        , onClick = { navController.navigate("OptionsMenu") })
                }
            }
        }
    }
}

@Composable
fun ImageWithNavigation(painter : Painter, onClick : () -> Unit) {
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
fun GreetingPreview() {
    VinilAppTheme {
        Home()
    }
}