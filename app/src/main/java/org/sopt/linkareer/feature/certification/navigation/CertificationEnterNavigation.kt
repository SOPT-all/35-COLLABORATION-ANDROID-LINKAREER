package org.sopt.linkareer.feature.certification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.CertificationEnterInformationRoute

@Serializable
data object CertificationEnterInfo : Route

fun NavController.navigateToCertificationEnterInformation(navOptions: NavOptions? = null) {
    navigate(
        route = CertificationEnterInfo,
        navOptions = navOptions
    )
}


fun NavGraphBuilder.certificationEnterInformation(
    navHostController: NavHostController,
) {
    composable<CertificationEnterInfo> {
        CertificationEnterInformationRoute(
            navigateToCertificationEnterInformation = { navHostController.navigateToCertificationSuccess() }
        )
    }
}