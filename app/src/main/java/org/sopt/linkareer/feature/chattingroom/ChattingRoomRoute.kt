package org.sopt.linkareer.feature.chattingroom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.core.designsystem.component.textfield.ChattingTextField
import org.sopt.linkareer.core.designsystem.component.topappbar.BackChattingRoomTopAppBar
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.feature.chattingroom.component.ChatRoomBottomNotice
import org.sopt.linkareer.feature.chattingroom.component.ChatRoomTopNotice
import org.sopt.linkareer.feature.chattingroom.component.MyReplyChat
import org.sopt.linkareer.feature.chattingroom.component.MychatBubble
import org.sopt.linkareer.feature.chattingroom.component.OtherUserChat
import org.sopt.linkareer.feature.chattingroom.component.OtherUserReplyChat
import timber.log.Timber
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun ChattingRoomRoute(
    navigateToCertificationGuide: () -> Unit,
    chatRoomViewModel: ChatRoomViewModel = hiltViewModel(),
) {
    val chatRoomState by chatRoomViewModel.chatRoomState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        chatRoomViewModel.getChatList()
    }

    when (chatRoomState) {
        is UiState.Empty -> Timber.tag("ChattingRoomRoute").d("chatRoomState is Empty")
        is UiState.Loading -> Timber.tag("ChattingRoomRoute").d("chatRoomState is Loading")
        is UiState.Success -> {
            val chatRoomStateData = (chatRoomState as UiState.Success<ChatRoomState>).data
            ChattingRoomScreen(
                navigateToCertificationGuide = navigateToCertificationGuide,
                chatListEntity = chatRoomStateData.chatListEntity,
            )
        }
        is UiState.Failure -> {
            val errorMessage = (chatRoomState as UiState.Failure).msg
            Timber.tag("ChattingRoomRoute").d("chatRoomState is Error: $errorMessage")
        }
    }
}

@Composable
fun ChattingRoomScreen(
    navigateToCertificationGuide: () -> Unit,
    chatListEntity: ChatListEntity,
) {
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    val sortedChatList =
        (chatListEntity.chatPartner.chatList + chatListEntity.myChat.chatList)
            .sortedBy { chat ->
                runCatching {
                    LocalTime.parse(chat.createdTime, timeFormatter)
                }.getOrElse {
                    LocalTime.MIN
                }
            }

    Column(
        modifier =
            Modifier
                .background(White),
    ) {
        BackChattingRoomTopAppBar(
            chattingRoomName = chatListEntity.chatRoomName,
            chattingRoomHeadCount = chatListEntity.chatParticiPantsCount,
            onBackButtonClick = { },
        )
        ChatRoomTopNotice()

        // 채팅 방
        LazyColumn(
            modifier =
                Modifier
                    .weight(1f)
                    .background(White),
        ) {
            items(sortedChatList) { chat ->
                // if -> 일반 채팅 / else -> 답장
                if (chat.reply == null) {
                    if (chatListEntity.myChat.chatList.contains(chat)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            MychatBubble(
                                sendMessage = chat.message,
                                timestamp = chat.createdTime,
                                likeCount = chat.likes,
                                isLiked = chat.pressedLike,
                            )
                        }
                    } else {
                        OtherUserChat(
                            nickName = chatListEntity.chatPartner.partnerName,
                            isChecked = chatListEntity.chatPartner.isBlueChecked,
                            jobCategory = chatListEntity.chatPartner.tag.job,
                            sendMessage = chat.message,
                            timestamp = chat.createdTime,
                            likeCount = chat.likes,
                            isLiked = chat.pressedLike,
                        )
                    }
                } else {
                    if (chatListEntity.myChat.chatList.contains(chat)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            MyReplyChat(
                                sender = chat.reply.repliedMessageSenderName ?: "",
                                receivedMessage = chat.reply.replyMessage ?: "",
                                replyMessage = chat.message,
                                timestamp = chat.createdTime,
                                likeCount = chat.likes,
                                isLiked = chat.pressedLike,
                            )
                        }
                    } else {
                        OtherUserReplyChat(
                            nickName = chatListEntity.chatPartner.partnerName,
                            isChecked = chatListEntity.chatPartner.isBlueChecked,
                            jobCategory = chatListEntity.chatPartner.tag.job,
                            sender = chat.reply.repliedMessageSenderName ?: "",
                            receivedMessage = chat.reply.replyMessage ?: "",
                            replyMessage = chat.message,
                            timestamp = chat.createdTime,
                            likeCount = chat.likes,
                            isLiked = chat.pressedLike,
                        )
                    }
                }
            }
        }

        ChatRoomBottomNotice(
            onClickToCheck = navigateToCertificationGuide,
            modifier =
                Modifier
                    .padding(horizontal = 18.dp),
        )
        HorizontalDivider(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp),
            thickness = Dp.Hairline,
            color = Gray300,
        )
        ChattingTextField(
            value = "",
            onValueChange = {},
            modifier =
                Modifier
                    .padding(horizontal = 18.dp, vertical = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChattingScreenPreview() {
    ChattingRoomScreen(
        navigateToCertificationGuide = {},
        ChatListEntity(),
    )
}
