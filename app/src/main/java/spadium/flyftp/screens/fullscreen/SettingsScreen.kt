package spadium.flyftp.screens.fullscreen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
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
fun SettingsScreen(parentNavController: NavHostController) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsListItem(configKey: Boolean, valueUIName: String, config: Any, context: Context) {
    ListItem(headlineContent = { /*TODO*/ })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsListItem(configKey: ColorModes, valueUIName: String, config: Any, context: Context) {
    ListItem(headlineContent = { /*TODO*/ }, Modifier.clickable {  } )
}