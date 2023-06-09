package spadium.flyftp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import spadium.flyftp.storage.config.ServerType

@Composable
fun ServerListScreen() {
    LazyColumn() {
        item {
            ServerListItem("Testing Server", "example.com", 21, ServerType.FTP)
        }
        item {
            ServerListItem("example.com", 21, ServerType.FTP)
        }
    }
}

@Composable
private fun ServerListItem(serverName: String, serverAddress: String, serverPort: Int, serverType: ServerType, modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(serverName) },
        supportingContent = { Text("$serverAddress:$serverPort") },
        trailingContent = { Text(serverType.toString()) }
    )
}

@Composable
private fun ServerListItem(serverAddress: String, serverPort: Int, serverType: ServerType, modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text("$serverAddress:$serverPort") },
        trailingContent = { Text(serverType.toString()) }
    )
}