package spadium.flyftp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import spadium.flyftp.serialization.ServerType
import spadium.flyftp.serialization.config

@Composable
fun HistoryScreen() {
    LazyColumn() {
        item {
            HistoryListItem("Myrient (ROMs)", "ftp.myrient.erista.me", 21, ServerType.FTP)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryListItem(fileName: String, serverAddress: String, serverPort: Int, serverType: ServerType, modifier: Modifier = Modifier) {
    ListItem(
        headlineText = { Text(fileName) },
        supportingText = { Text("$serverAddress:$serverPort") },
        trailingContent = { Text(serverType.toString()) }
    )
}