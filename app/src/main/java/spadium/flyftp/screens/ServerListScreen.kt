package spadium.flyftp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import spadium.flyftp.serialization.ServerType

@Composable
fun ServerListScreen() {
    LazyColumn() {
        item {
            ServerListItem("Myrient (ROMs)", "ftp.myrient.erista.me", 21, ServerType.FTP)
        }
        item {
            ServerListItem("ftp.myrient.erista.me", 21, ServerType.FTP)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ServerListItem(serverName: String, serverAddress: String, serverPort: Int, serverType: ServerType, modifier: Modifier = Modifier) {
    ListItem(
        headlineText = { Text(serverName) },
        supportingText = { Text("$serverAddress:$serverPort") },
        trailingContent = { Text(serverType.toString()) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ServerListItem(serverAddress: String, serverPort: Int, serverType: ServerType, modifier: Modifier = Modifier) {
    ListItem(
        headlineText = { Text("$serverAddress:$serverPort") },
        trailingContent = { Text(serverType.toString()) }
    )
}