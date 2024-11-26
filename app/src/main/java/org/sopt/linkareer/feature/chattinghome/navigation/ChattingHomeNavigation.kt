package org.sopt.linkareer.feature.chattinghome.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.linkareer.core.navigation.ChattingHome
import org.sopt.linkareer.feature.chattinghome.ChattingHomeRoute
import org.sopt.linkareer.feature.chattingroom.navigation.navigateToChattingRoom

fun NavController.navigateToChattingHome(navOptions: NavOptions? = null) {
    navigate(
        route = ChattingHome,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.chattingHomeGraph(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
) {
    composable<ChattingHome> {
        ChattingHomeRoute(
            paddingValues,
            navigateToChattingRoom = { navHostController.navigateToChattingRoom() },
        )
    }
}
