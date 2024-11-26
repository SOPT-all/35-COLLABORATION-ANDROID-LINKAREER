package org.sopt.linkareer.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.linkareer.R
import org.sopt.linkareer.core.navigation.Calendar
import org.sopt.linkareer.core.navigation.ChattingHome
import org.sopt.linkareer.core.navigation.Community
import org.sopt.linkareer.core.navigation.Home
import org.sopt.linkareer.core.navigation.MainTabRoute
import org.sopt.linkareer.core.navigation.Menu
import org.sopt.linkareer.core.navigation.Route

enum class MainTab(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val contentDescription: Int,
    val route: MainTabRoute,
) {
    MENU(
        selectedIcon = R.drawable.ic_menu_active_32,
        unselectedIcon = R.drawable.ic_menu_inactive_32,
        contentDescription = R.string.menu,
        route = Menu,
    ),
    COMMUNITY(
        selectedIcon = R.drawable.ic_community_active_32,
        unselectedIcon = R.drawable.ic_community_inactive_32,
        contentDescription = R.string.community,
        route = Community,
    ),
    HOME(
        selectedIcon = R.drawable.ic_home_active_32,
        unselectedIcon = R.drawable.ic_home_inactive_32,
        contentDescription = R.string.home,
        route = Home,
    ),
    CALENDAR(
        selectedIcon = R.drawable.ic_calendar_active_32,
        unselectedIcon = R.drawable.ic_calendar_inactive_32,
        contentDescription = R.string.calendar,
        route = Calendar,
    ),
    CHATTING(
        selectedIcon = R.drawable.ic_chatting_active_32,
        unselectedIcon = R.drawable.ic_chatting_inactive_32,
        contentDescription = R.string.chatting,
        route = ChattingHome,
    ), ;

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
