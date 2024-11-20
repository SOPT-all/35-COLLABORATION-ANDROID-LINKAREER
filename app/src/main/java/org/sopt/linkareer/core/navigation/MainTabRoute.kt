package org.sopt.linkareer.core.navigation

import kotlinx.serialization.Serializable

interface MainTabRoute : Route

@Serializable
data object Menu : MainTabRoute

@Serializable
data object Community : MainTabRoute

@Serializable
data object Home : MainTabRoute

@Serializable
data object Calendar : MainTabRoute

@Serializable
data object Chatting : MainTabRoute
