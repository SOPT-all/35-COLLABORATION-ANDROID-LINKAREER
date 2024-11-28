package org.sopt.linkareer.domain.model

data class ChatListEntity(
    val chatRoomName: String = "",
    val chatParticiPantsCount: Int = 0,
    val chatPartner: ChatPartnerEntity = ChatPartnerEntity(),
    val myChat: MyChatEntity = MyChatEntity(),
)

data class ChatPartnerEntity(
    val partnerName: String = "",
    val isBlueChecked: Boolean = false,
    val tag: TagEntity = TagEntity(),
    val chatList: List<ChatEntity> = emptyList(),
)

data class TagEntity(
    val companyName: String = "",
    val job: String = "",
)

data class ChatEntity(
    val message: String = "",
    val isReplied: Boolean = false,
    val likes: Int = 0,
    val pressedLike: Boolean = false,
    val createdTime: String = "",
    val reply: ReplyEntity = ReplyEntity(),
)

data class ReplyEntity(
    val replyMessage: String? = null,
    val repliedMessageSenderName: String? = null,
)

data class MyChatEntity(
    val chatList: List<ChatEntity> = emptyList(),
)
