package org.sopt.linkareer.feature.chattingroom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.core.designsystem.component.textfield.ChattingTextField
import org.sopt.linkareer.core.designsystem.component.topappbar.BackChattingRoomTopAppBar
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.data.model.response.MyChat
import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.feature.chattingroom.component.ChatRoomBottomNotice
import org.sopt.linkareer.feature.chattingroom.component.ChatRoomTopNotice
import org.sopt.linkareer.feature.chattingroom.component.MyReplyChat
import org.sopt.linkareer.feature.chattingroom.component.MychatBubble
import org.sopt.linkareer.feature.chattingroom.component.OtherUserChat
import org.sopt.linkareer.feature.chattingroom.component.OtherUserReplyChat
import timber.log.Timber

@Composable
fun ChattingRoomRoute(
    //navigateToCertification: () -> Unit,
    chatRoomViewModel: ChatRoomViewModel = hiltViewModel()
) {
    val chatRoomState by chatRoomViewModel.chatRoomState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        chatRoomViewModel.getChatList()
    }

    when(chatRoomState) {
        is UiState.Empty -> Timber.tag("ChattingRoomRoute").d("chatRoomState is Empty")
        is UiState.Loading -> Timber.tag("ChattingRoomRoute").d("chatRoomState is Loading")
        is UiState.Success -> {
            val chatRoomStateData = (chatRoomState as UiState.Success<ChatRoomState>).data
            ChattingRoomScreen(
                paddingValues = PaddingValues(top = 27.dp),
                chatListEntity = chatRoomStateData.chatListEntity
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
    paddingValues: PaddingValues,
    chatListEntity: ChatListEntity
) {
    Column(
        modifier =
            Modifier
                .padding(paddingValues)
                .background(White),
    ) {
        BackChattingRoomTopAppBar(
            chattingRoomName = chatListEntity.chatRoomName,
            chattingRoomHeadCount = chatListEntity.chatParticiPantsCount,
            onBackButtonClick = {}, // 뒤로가기
        )
        ChatRoomTopNotice()

        // 채팅 방
        LazyColumn(
            modifier =
                Modifier
                    .background(White),
        ) {
            items(chatListEntity.chatPartner.chatList) { chat ->
                if (chat.reply == null) {
                    OtherUserChat(
                        nickName = chatListEntity.chatPartner.partnerName,
                        isChecked = chatListEntity.chatPartner.isBlueChecked,
                        jobCategory = chatListEntity.chatPartner.tag.job,
                        imageUrl = "",
                        sendMessage = chat.message,
                        timestamp = chat.createdTime,
                    )
                } else {
                    OtherUserReplyChat(
                        nickName = chatListEntity.chatPartner.partnerName,
                        isChecked = chatListEntity.chatPartner.isBlueChecked,
                        jobCategory = chatListEntity.chatPartner.tag.job,
                        imageUrl = "",
                        sender = chat.reply.repliedMessageSenderName ?: "",
                        receivedMessage = chat.reply.replyMessage ?: "",
                        replyMessage = chat.message,
                        timestamp = chat.createdTime,
                    )
                }
            }
            items(chatListEntity.myChat.chatList) { myChat ->
                if (myChat.reply == null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        MychatBubble(
                            sendMessage = myChat.message,
                            timestamp = myChat.createdTime
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        MyReplyChat(
                            sender = myChat.reply.repliedMessageSenderName ?: "",
                            receivedMessage = myChat.reply.replyMessage ?: "",
                            replyMessage = myChat.message,
                            timestamp = myChat.createdTime
                        )
                    }
                }
            }
        }

        ChatRoomBottomNotice(
            onClickToCheck = {},
            modifier =
                Modifier
                    .padding(horizontal = 18.dp)
                    .padding(bottom = 1.dp),
        )
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(White)
                    .drawBehind {
                        drawLine(
                            color = Gray300,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 1.dp.toPx(),
                        )
                    }
                    .padding(vertical = 12.dp, horizontal = 18.dp),
        ) {
            ChattingTextField(
                value = "",
                onValueChange = {},
                modifier =
                    Modifier
                        .padding(horizontal = 18.dp, vertical = 12.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChattingScreenPreview() {
    //ChattingRoomScreen()
}
