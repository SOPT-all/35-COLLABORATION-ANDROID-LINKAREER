package org.sopt.linkareer.feature.certification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.ChattingHome
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.CertificationCheckSuccessRoute
import org.sopt.linkareer.feature.chattingroom.navigation.navigateToChattingRoom

@Serializable
data object CertificationSuccess : Route

fun NavController.navigateToCertificationSuccess(navOptions: NavOptions? = null) {
    navigate(
        route = CertificationSuccess,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.certificationSuccess(
    navHostController: NavHostController,
) {
    composable<CertificationSuccess> {
        CertificationCheckSuccessRoute(
            navigateToChattingRoom = {
                navHostController.navigateToChattingRoom(
                    navOptions =
                        NavOptions.Builder()
                            .setPopUpTo(
                                route = ChattingHome,
                                inclusive = false,
                            )
                            .setLaunchSingleTop(true)
                            .build(),
                )
            },
        )
    }
}
