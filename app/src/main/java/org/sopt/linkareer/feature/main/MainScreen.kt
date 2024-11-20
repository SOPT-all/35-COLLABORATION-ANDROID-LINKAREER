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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import org.sopt.linkareer.core.designsystem.Black
import org.sopt.linkareer.core.designsystem.LINKareerTheme
import org.sopt.linkareer.core.designsystem.White
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
                selected = currentTab == itemType,
                onClick = {
                    onTabSelected(itemType)
                },
                icon = {
                    Image(
                        painter = painterResource(id = if (currentTab == itemType) itemType.selectedIcon else itemType.unselectedIcon),
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
                        selectedIconColor = Color.Blue,
                        selectedTextColor = Black,
                        selectedIndicatorColor = White,
                        unselectedIconColor = Black,
                        unselectedTextColor = Black,
                        disabledTextColor = Black,
                        disabledIconColor = Black,
                    ),
            )
        }
    }
}
