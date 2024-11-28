package org.sopt.linkareer.feature.chattingroom

import org.sopt.linkareer.domain.model.ChatListEntity

data class ChatRoomState(
    val chatListEntity: ChatListEntity = ChatListEntity(),
)
