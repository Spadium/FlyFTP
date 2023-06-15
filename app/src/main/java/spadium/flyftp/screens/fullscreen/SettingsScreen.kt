package spadium.flyftp.screens.fullscreen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import spadium.config.ConfigItem
import spadium.config.ConfigManager
import spadium.flyftp.storage.config.ColorModes
import spadium.flyftp.storage.config.getTranslatedKeyName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(parentNavController: NavHostController, configManager: ConfigManager, context: Context) {
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
            items(items = configManager.getAllEntries()) { key ->
                SettingsListItem(configKey = key, configManager = configManager, context = context)
            }
        }
    }
}

@Composable
fun SettingsListItem(configKey: ConfigItem<Any>, configManager: ConfigManager, context: Context) {
    ListItem(
        headlineContent = { Text(configKey.getTranslatedKeyName(configKey.key, context)) },
        supportingContent = { Text(configKey.description) },
        trailingContent = {
            when (configKey.valueType) {
                is Boolean -> BooleanSwitch(configKey)
                else -> Text(configKey.valueType.toString())
            }
        }
    )
}

@Composable
fun BooleanSwitch(configKey: ConfigItem<Any>) {
    var switchState by remember { mutableStateOf(configKey.value as Boolean) }

    Switch(
        checked = switchState,
        onCheckedChange = {
            switchState = it
            configKey.value = switchState

        }
    )
}