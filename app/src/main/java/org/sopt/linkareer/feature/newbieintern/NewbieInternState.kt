package org.sopt.linkareer.feature.newbieintern

import org.sopt.linkareer.domain.model.ChattingRoomEntity
import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.model.PassGuideEntity
import org.sopt.linkareer.domain.model.PostEntity
import org.sopt.linkareer.domain.model.RoadMapEntity
import org.sopt.linkareer.domain.model.getChattingRoomList
import org.sopt.linkareer.feature.home.getOfficialList
import org.sopt.linkareer.feature.home.getPostList

data class NewbieInternState(
    val officialList: List<OfficialEntity> = getOfficialList(),
    val roadMapList: List<RoadMapEntity> = getRoadMapList(),
    val passGuideList: List<PassGuideEntity> = getPassGuideList(),
    val postList: List<PostEntity> = getPostList(),
    val chattingRoomList: List<ChattingRoomEntity> = getChattingRoomList(),
)
