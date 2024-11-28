package org.sopt.linkareer.feature.certification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.CertificationCheckSuccessRoute
import org.sopt.linkareer.feature.certification.CertificationEnterInformationRoute
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

@Serializable
data object CertificationSuccess : Route

fun NavController.navigateToCertificationSuccess(navOptions: NavOptions? = null) {
    navigate(
        route = CertificationSuccess,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.certificationSuccess(
    navHostController: NavHostController,
) {
    composable<CertificationSuccess> {
        CertificationCheckSuccessRoute()
    }
}

