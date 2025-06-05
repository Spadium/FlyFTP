package spadium.flyftp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Storage
import androidx.compose.ui.graphics.vector.ImageVector

open class Screens(val route: String, val title: String) {
    open class AppBarScreens(
        route: String,
        title: String,
        val icon: ImageVector
    ) : Screens(route, title) {
        object Servers : AppBarScreens("serverList", "Servers", Icons.Rounded.Storage)
        object Downloads : AppBarScreens("activeDownloads", "Downloads", Icons.Rounded.Download)
        object History : AppBarScreens("historicalDownloads", "History", Icons.Rounded.History)
    }

    object MainPage : Screens("main", "FlyFTP")
    object Settings : Screens("settings", "Settings")
    object AccountPage : Screens("accountManager", "Accounts")
    object AboutPage : Screens("about", "About")

    fun withArgument(arg: String): Screens {
        val newRoute: String = "${this.route}/$arg"
        return Screens(newRoute, this.title)
    }
}