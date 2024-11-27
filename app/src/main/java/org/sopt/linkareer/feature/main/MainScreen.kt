package org.sopt.linkareer.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
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
import org.sopt.linkareer.core.designsystem.component.topappbar.LogoTopAppBar
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.util.NoRippleInteraction
import org.sopt.linkareer.feature.chattinghome.navigation.chattingHomeGraph
import org.sopt.linkareer.feature.chattingroom.navigation.chattingRoomGraph
import org.sopt.linkareer.feature.home.navigation.homeNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator,
) {
    Scaffold(
        topBar = {
            if (navigator.currentTab == MainTab.HOME || navigator.currentTab == MainTab.CHATTING) {
                LogoTopAppBar()
            }
        },
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
                    .fillMaxSize()
                    .statusBarsPadding(),
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
                chattingHomeGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )
                chattingRoomGraph(
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
