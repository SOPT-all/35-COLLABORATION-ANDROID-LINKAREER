package org.sopt.linkareer.feature.newbieintern

import org.sopt.linkareer.domain.model.ChattingRoomEntity
import org.sopt.linkareer.domain.model.PassGuideEntity
import org.sopt.linkareer.domain.model.RoadMapEntity
import org.sopt.linkareer.domain.model.getChattingRoomList

data class NewbieInternState(
    val roadMapList: List<RoadMapEntity> = getRoadMapList(),
    val passGuideList: List<PassGuideEntity> = getPassGuideList(),
    val chattingRoomList: List<ChattingRoomEntity> = getChattingRoomList(),
)