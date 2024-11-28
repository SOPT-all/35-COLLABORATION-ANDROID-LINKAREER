package org.sopt.linkareer.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.linkareer.domain.model.ChatEntity
import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.domain.model.ChatPartnerEntity
import org.sopt.linkareer.domain.model.MyChatEntity
import org.sopt.linkareer.domain.model.ReplyEntity
import org.sopt.linkareer.domain.model.TagEntity

@Serializable
data class ChatListResponse(
    @SerialName("chatRoomName") val chatRoomName: String,
    @SerialName("chatParticiPantsCount") val chatParticiPantsCount: Int = 0,
    @SerialName("chatPartner") val chatPartner: ChatPartner,
    @SerialName("myChat") val myChat: MyChat,
) {
    fun chatListResponseToEntity(): ChatListEntity {
        return ChatListEntity(
            chatRoomName = this.chatRoomName,
            chatParticiPantsCount = this.chatParticiPantsCount,
            chatPartner = this.chatPartner.chatPartnerToEntity(),
            myChat = this.myChat.myChatToEntity(),
        )
    }
}

@Serializable
data class ChatPartner(
    @SerialName("partnerName") val partnerName: String,
    @SerialName("isBlueChecked") val isBlueChecked: Boolean,
    @SerialName("tag") val tag: Tag,
    @SerialName("chatList") val chatList: List<Chat>,
) {
    fun chatPartnerToEntity(): ChatPartnerEntity {
        return ChatPartnerEntity(
            partnerName = this.partnerName,
            isBlueChecked = this.isBlueChecked,
            tag = this.tag.tagToEntity(),
            chatList = this.chatList.map { it.chatToEntity() },
        )
    }
}

@Serializable
data class Tag(
    @SerialName("companyName") val companyName: String,
    @SerialName("job") val job: String,
) {
    fun tagToEntity(): TagEntity {
        return TagEntity(
            companyName = this.companyName,
            job = this.job,
        )
    }
}

@Serializable
data class Chat(
    @SerialName("message") val message: String,
    @SerialName("isReplied") val isReplied: Boolean,
    @SerialName("likes") val likes: Int,
    @SerialName("pressedLike") val pressedLike: Boolean,
    @SerialName("createdTime") val createdTime: String,
    @SerialName("reply") val reply: Reply,
) {
    fun chatToEntity(): ChatEntity {
        return ChatEntity(
            message = this.message,
            isReplied = this.isReplied,
            likes = this.likes,
            pressedLike = this.pressedLike,
            createdTime = this.createdTime,
            reply = this.reply.replyToEntity(),
        )
    }
}

@Serializable
data class Reply(
    @SerialName("replyMessage") val replyMessage: String?,
    @SerialName("repliedMessageSenderName") val repliedMessageSenderName: String?,
) {
    fun replyToEntity(): ReplyEntity {
        return ReplyEntity(
            replyMessage = this.replyMessage,
            repliedMessageSenderName = this.repliedMessageSenderName,
        )
    }
}

@Serializable
data class MyChat(
    @SerialName("chatList") val chatList: List<Chat>,
) {
    fun myChatToEntity(): MyChatEntity {
        return MyChatEntity(
            chatList = this.chatList.map { it.chatToEntity() },
        )
    }
}
