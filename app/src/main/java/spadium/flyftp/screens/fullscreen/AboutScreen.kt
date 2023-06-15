package spadium.flyftp.screens.fullscreen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Square
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import spadium.flyftp.storage.config.ColorModes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(parentNavController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About FlyFTP") },
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

@Composable
fun appInfoRow() {
    Row() {
        Icon(Icons.Rounded.Square, "FlyFTP Icon")
        Text("FlyFTP")
    }
}