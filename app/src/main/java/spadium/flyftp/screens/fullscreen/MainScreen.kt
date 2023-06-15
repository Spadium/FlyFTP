package spadium.flyftp.screens.fullscreen

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import spadium.flyftp.screens.HistoryScreen
import spadium.flyftp.screens.Screens
import spadium.flyftp.screens.ServerListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(parentNavController: NavHostController) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        floatingActionButton = {
            if (currentDestination != null) {
                if (currentDestination.route == Screens.AppBarScreens.Servers.route) {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Add, "Add a server")
                    }
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("FlyFTP") },
                actions = {
                    IconButton(onClick = { parentNavController.navigate(Screens.AboutPage.route) }) {
                        Icon(Icons.Outlined.Info, "About icon")
                    }
                    IconButton(onClick = { parentNavController.navigate(Screens.Settings.route) }) {
                        Icon(Icons.Outlined.Settings, "Settings icon")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                navBarAccessableScreens.forEach {
                        screen ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.AppBarScreens.Servers.route,
            modifier = Modifier.padding(it),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(Screens.AppBarScreens.Servers.route) { ServerListScreen() }
            composable(Screens.AppBarScreens.Downloads.route) {}
            composable(Screens.AppBarScreens.History.route) { HistoryScreen() }
        }
    }
}

val navBarAccessableScreens = listOf(
    Screens.AppBarScreens.Servers,
    Screens.AppBarScreens.Downloads,
    Screens.AppBarScreens.History
)