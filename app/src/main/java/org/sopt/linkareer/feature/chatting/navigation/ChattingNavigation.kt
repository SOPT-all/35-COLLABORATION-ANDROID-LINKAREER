package org.sopt.linkareer.feature.chatting.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.linkareer.core.navigation.Chatting
import org.sopt.linkareer.feature.chatting.ChattingRoute

fun NavController.navigateToChatting(navOptions: NavOptions? = null) {
    navigate(
        route = Chatting,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.chattingGraph(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
) {
    composable<Chatting> {
        ChattingRoute(paddingValues)
    }
}
