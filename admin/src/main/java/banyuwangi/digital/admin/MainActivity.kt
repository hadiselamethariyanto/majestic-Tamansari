package banyuwangi.digital.admin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import banyuwangi.digital.admin.di.adminModule
import banyuwangi.digital.admin.ui.navigation.Drawer
import banyuwangi.digital.admin.ui.navigation.Screen
import banyuwangi.digital.admin.ui.screens.attraction.list.AttractionScreen
import banyuwangi.digital.admin.ui.screens.HomeScreen
import banyuwangi.digital.admin.ui.screens.HomestayScreen
import banyuwangi.digital.admin.ui.screens.attraction.detail.AttractionDetailScreen
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import banyuwangi.digital.admin.utils.Utils.fromJson
import banyuwangi.digital.core.domain.model.WisataDomain
import kotlinx.coroutines.launch
import org.koin.core.context.loadKoinModules

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(adminModule)
        setContent {
            TamansariTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppMainScreen()
                }
            }
        }
    }
}

@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(Screen.Attraction.route) {
                    AttractionScreen(
                        openDrawer = {
                            openDrawer()
                        },
                        navController = navController
                    )
                }
                composable(Screen.Homestay.route) {
                    HomestayScreen {
                        openDrawer()
                    }
                }
                composable(
                    route = Screen.AttractionDetail.route,
                    arguments = listOf(
                        navArgument("id") { NavType.StringType },
                        navArgument("data") { NavType.StringType })
                ) { backStackEntry ->
                    backStackEntry.arguments?.getString("data").let { jsonString ->
                        val attraction = jsonString?.fromJson(WisataDomain::class.java)
                        AttractionDetailScreen(
                            navController = navController,
                            attraction = attraction
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TamansariTheme {
        AppMainScreen()
    }
}
