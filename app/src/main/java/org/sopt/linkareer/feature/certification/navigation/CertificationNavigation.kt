package org.sopt.linkareer.feature.certification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.linkareer.core.navigation.Route
import org.sopt.linkareer.feature.certification.CertificationGuideRoute

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
        CertificationGuideRoute()
    }
}

fun NavController.navigateToCertificationEnterInfo(navOptions: NavOptions? = null) {
    navigate(
        route = CertificationEnterInfo,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.certificationEnterInfo(
    navHostController: NavHostController,
) {
    composable<CertificationEnterInfo> {
        CertificationGuideRoute()
    }
}

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
        CertificationGuideRoute()
    }
}

@Serializable
data object CertificationGuide : Route

@Serializable
data object CertificationEnterInfo : Route

@Serializable
data object CertificationSuccess : Route

