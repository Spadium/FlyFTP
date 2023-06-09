package spadium.flyftp.screens.fullscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(parentNavController: NavHostController) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FlyFTP Settings") },
                navigationIcon = { IconButton(onClick = { parentNavController.navigateUp() }) {
                    Icon(Icons.Rounded.ArrowBack, "Back arrow")
                } }
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            item {

            }
        }
    }
}

