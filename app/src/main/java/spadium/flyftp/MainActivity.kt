package spadium.flyftp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import spadium.flyftp.screens.fullscreen.MainScreen
import spadium.flyftp.screens.Screens
import spadium.flyftp.screens.fullscreen.SettingsScreen
import spadium.flyftp.serialization.Config
import spadium.flyftp.serialization.config
import spadium.flyftp.ui.theme.FlyFTPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        config = Config.initializeConfiguration(applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            FlyFTPTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainPage.route
                    ) {
                        composable(Screens.MainPage.route) { MainScreen(navController) }
                        composable(Screens.Settings.route) { SettingsScreen(navController) }
                        composable(Screens.AboutPage.route) { Text("About the app") }
                    }
                }
            }
        }
    }

    val otherScreens = listOf(
        Screens.Settings,
        Screens.AboutPage
    )
}