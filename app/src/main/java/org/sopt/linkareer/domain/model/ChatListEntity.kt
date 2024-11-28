package org.sopt.linkareer.domain.model

data class ChatListEntity(
    val chatRoomName: String,
    val chatParticiPantsCount: Int,
    val chatPartner: ChatPartnerEntity,
    val myChat: MyChatEntity,
)

data class ChatPartnerEntity(
    val partnerName: String,
    val isBlueChecked: Boolean,
    val tag: TagEntity,
    val chatList: List<ChatEntity>,
)

data class TagEntity(
    val companyName: String = "",
    val job: String = "",
)

data class ChatEntity(
    val message: String,
    val isReplied: Boolean,
    val likes: Int,
    val pressedLike: Boolean,
    val createdTime: String,
    val reply: ReplyEntity,
)

data class ReplyEntity(
    val replyMessage: String?,
    val repliedMessageSenderName: String?,
)

data class MyChatEntity(
    val chatList: List<ChatEntity>,
)
