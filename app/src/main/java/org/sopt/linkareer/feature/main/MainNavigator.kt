package org.sopt.linkareer.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.linkareer.core.navigation.Home
import org.sopt.linkareer.feature.chattinghome.navigation.navigateToChattingHome
import org.sopt.linkareer.feature.home.navigation.navigateToHome

class MainNavigator(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() =
            navController
                .currentBackStackEntryAsState().value?.destination

    val startDestination = Home

    val currentTab: MainTab?
        @Composable get() =
            MainTab.find { tab ->
                currentDestination?.hasRoute(tab::class) == true
            }

    fun navigate(tab: MainTab) {
        val navOptions =
            navOptions {
                navController.currentDestination?.route?.let {
                    popUpTo(it) {
                        inclusive = true
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.CHATTING -> navController.navigateToChattingHome(navOptions)
            else -> {}
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    @Composable
    fun showBottomBar() =
        MainTab.contains {
            currentDestination?.hasRoute(it::class) == true
        }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator =
    remember(navController) {
        MainNavigator(navController)
    }
