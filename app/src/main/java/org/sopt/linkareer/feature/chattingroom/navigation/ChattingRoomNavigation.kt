package org.sopt.linkareer.feature.chattingroom.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.navigation.navigateToCertificationGuide
import org.sopt.linkareer.feature.chattingroom.ChattingRoomRoute

fun NavController.navigateToChattingRoom(navOptions: NavOptions? = null) {
    navigate(
        route = ChattingRoom,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.chattingRoomGraph(
    navHostController: NavHostController,
) {
    composable<ChattingRoom> {
        ChattingRoomRoute(
            navigateToCertificationGuide = { navHostController.navigateToCertificationGuide() },
        )
    }
}

@Serializable
data object ChattingRoom : Route
