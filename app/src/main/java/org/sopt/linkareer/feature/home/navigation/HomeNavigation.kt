package org.sopt.linkareer.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.linkareer.core.navigation.Home
import org.sopt.linkareer.feature.home.HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(
        route = Home,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
) {
    composable<Home> {
        HomeRoute(paddingValues)
    }
}