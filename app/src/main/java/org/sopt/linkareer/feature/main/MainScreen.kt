package org.sopt.linkareer.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.util.NoRippleInteraction
import org.sopt.linkareer.feature.chatting.navigation.chattingGraph
import org.sopt.linkareer.feature.home.navigation.homeNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator,
) {
    Scaffold(
        bottomBar = {
            if (navigator.showBottomBar()) {
                MainBottomBar(
                    tabs = MainTab.entries.toList(),
                    currentTab = navigator.currentTab,
                    onTabSelected = navigator::navigate,
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize(),
        ) {
            NavHost(
                enterTransition = {
                    EnterTransition.None
                },
                exitTransition = {
                    ExitTransition.None
                },
                popEnterTransition = {
                    EnterTransition.None
                },
                popExitTransition = {
                    ExitTransition.None
                },
                navController = navigator.navController,
                startDestination = navigator.startDestination,
            ) {
                homeNavGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )
                chattingGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )
            }
        }
    }
}

@Composable
private fun MainBottomBar(
    tabs: List<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    NavigationBar(containerColor = White) {
        tabs.forEach { itemType ->
            NavigationBarItem(
                interactionSource = NoRippleInteraction,
                selected = currentTab == itemType,
                onClick = {
                    onTabSelected(itemType)
                },
                icon = {
                    Image(
                        imageVector = ImageVector.vectorResource(id = if (currentTab == itemType) itemType.selectedIcon else itemType.unselectedIcon),
                        contentDescription = stringResource(id = itemType.contentDescription),
                    )
                },
                label = {
                    Text(
                        stringResource(id = itemType.contentDescription),
                        style = LINKareerTheme.typography.label4M10,
                    )
                },
                colors =
                    NavigationBarItemColors(
                        selectedIconColor = Gray900,
                        selectedTextColor = Gray900,
                        selectedIndicatorColor = White,
                        unselectedIconColor = Gray600,
                        unselectedTextColor = Gray600,
                        disabledTextColor = Gray600,
                        disabledIconColor = Gray600,
                    ),
            )
        }
    }
}
