package org.sopt.linkareer.feature.certification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.CertificationGuideRoute

@Serializable
data object CertificationGuide : Route

fun NavController.navigateToCertificationGuide(navOptions: NavOptions? = null) {
    navigate(
        route = CertificationGuide,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.certificationGuideGuide(
    navHostController: NavHostController,
) {
    composable<CertificationGuide> {
        CertificationGuideRoute(
            navigateToCertificationEnterInformation = { navHostController.navigateToCertificationEnterInformation() }
        )
    }
}

