package org.sopt.linkareer.feature.newbieintern.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.chattingroom.navigation.navigateToChattingRoom
import org.sopt.linkareer.feature.newbieintern.NewbieInternRoute

fun NavController.navigateToNewbieIntern(navOptions: NavOptions? = null) {
    navigate(
        route = NewbieIntern,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.newbieInternNavGraph(
    paddingValues: PaddingValues,
    navHostController: NavController,
) {
    composable<NewbieIntern> {
        NewbieInternRoute(
            navigateBack = { navHostController.popBackStack() },
            navigateToChattingRoom = { navHostController.navigateToChattingRoom() },
            paddingValues = paddingValues,
        )
    }
}

@Serializable
data object NewbieIntern : Route
