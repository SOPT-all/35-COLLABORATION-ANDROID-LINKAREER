package org.sopt.linkareer.feature.chattinghome

import org.sopt.linkareer.domain.model.ChattingRoomEntity
import org.sopt.linkareer.domain.model.getChattingRoomList

data class ChattingHomeState(
    val searchText: String = "",
    val isMyChattingRoom: Boolean = true,
    val chattingRoomTab: Int = 0,
    val chattingRoomList: List<ChattingRoomEntity> = getChattingRoomList(),
)
