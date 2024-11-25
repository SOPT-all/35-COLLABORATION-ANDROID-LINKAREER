package org.sopt.linkareer.feature.chatting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.component.textfield.ChattingTextField
import org.sopt.linkareer.core.designsystem.component.topappbar.BackChattingRoomTopAppBar
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.feature.chatting.component.ChatRoomBottomNotice
import org.sopt.linkareer.feature.chatting.component.ChatRoomTopNotice
import org.sopt.linkareer.feature.chatting.component.OtherUserChat
import org.sopt.linkareer.feature.chatting.component.OtherUserReplyChat

@Composable
fun ChattingRoute(
    paddingValues: PaddingValues,
) {
    ChattingScreen(paddingValues)
}

@Composable
fun ChattingScreen(
    paddingValues: PaddingValues,
) {
    Column(
        modifier =
            Modifier
                .padding(paddingValues)
                .background(White),
    ) {
        BackChattingRoomTopAppBar(
            chattingRoomName = "현대자동차",
            chattingRoomHeadCount = 1294,
            onBackButtonClick = {}
        )
        ChatRoomTopNotice()

//        // 채팅 방
        LazyColumn (
            modifier = Modifier
                .background(White)
        ) {
            // 채팅쪽은 서버 구현하면서 만들어야 함
            item {
                OtherUserChat(
                    nickName = "검은색 고양이",
                    isChecked = true,
                    jobCategory = "현대 자동차",
                    imageUrl = "",
                    sendMessage = "안녕하세요 만나서 반가워요",
                    timestamp = "00:00"
                )
            }
            item {
                OtherUserReplyChat(
                    nickName = "연두색 물고기",
                    isChecked = false,
                    jobCategory = "올리브영",
                    imageUrl = "",
                    sender = "검은색 고양이",
                    receivedMessage = "반갑습니다. 고양이 보은",
                    replyMessage = "안녕하세요 저도 만나서 반가워요",
                    timestamp = "00:00"
                )
            }
        }
        ChatRoomBottomNotice(
            onClickDelete = {},
            onClickToCheck = {},
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .padding(bottom = 1.dp)
        )
        Box(
            modifier = Modifier
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
                onValueChange ={} ,
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 12.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChattingScreenPreview() {
    ChattingScreen(
        paddingValues = PaddingValues(vertical = 8.dp)
    )
}
