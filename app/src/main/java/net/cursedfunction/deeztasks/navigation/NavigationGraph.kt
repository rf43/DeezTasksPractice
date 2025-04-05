package net.cursedfunction.deeztaskz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.cursedfunction.deeztaskz.ui.home.HomeScreenRoute
import net.cursedfunction.deeztaskz.ui.home.HomeScreenViewModel

enum class ScreenRoute(val route: String) {
    HOME("home"),
    COMPLETED_TASKS("completedTasks")
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String = ScreenRoute.HOME.route
) {
    NavHost(navController, startDestination) {
        composable(route = ScreenRoute.HOME.route) {
            HomeScreenRoute(
                viewModel = HomeScreenViewModel()
            )
        }
        composable(route = ScreenRoute.COMPLETED_TASKS.route) {

        }
    }
}