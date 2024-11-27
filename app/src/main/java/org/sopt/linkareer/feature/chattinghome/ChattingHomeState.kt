package org.sopt.linkareer.feature.chattinghome

data class ChattingHomeState(
    val searchText: String = "",
    val isMyChattingRoom: Boolean = true,
    val chattingRoomTab: Int = 0,
    val chattingRoomList: List<String> = listOf(),
)
