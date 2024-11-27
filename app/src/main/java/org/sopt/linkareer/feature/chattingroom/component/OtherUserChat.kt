package org.sopt.linkareer.feature.chattingroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun OtherUserChat(
    nickName: String,
    isChecked: Boolean,
    jobCategory: String,
    sendMessage: String,
    timestamp: String,
    likeCount: Int,
    isLiked: Boolean,
) {
    Column {
        OtherUserChatProfile(
            nickName = nickName,
            isChecked = isChecked,
            jobCategory = jobCategory,
        )
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Column(
                modifier =
                    Modifier
                        .widthIn(max = 230.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Blue50)
                        .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Bottom),
            ) {
                Text(
                    text = sendMessage,
                    style = LINKareerTheme.typography.body8M13,
                    color = Gray900,
                    modifier =
                        Modifier
                            .widthIn(max = 230.dp),
                )
            }
            Text(
                text = timestamp,
                style = LINKareerTheme.typography.body13R11,
                color = Gray600,
                modifier =
                    Modifier
                        .padding(start = 4.dp),
            )
        }
        if (isLiked || likeCount > 0) {
            ChatLikeCount(
                likeCount = likeCount,
                isLiked = isLiked,
                modifier =
                    Modifier
                        .padding(start = 30.dp, top = 4.dp, bottom = 12.dp),
            )
        } else {
            Image(
                painter = painterResource(R.drawable.ic_chatting_like_inactive_25),
                contentDescription = stringResource(R.string.chatroom_reply_contentDescription),
                modifier =
                    Modifier
                        .padding(start = 30.dp, top = 4.dp),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun OtherUserChatPreview() {
    LINKareerAndroidTheme {
        OtherUserChat(
            nickName = "무관심한 맥",
            isChecked = true,
            jobCategory = "현대 자동차",
            sendMessage = "굳이 꾸밀 필요없습니다.",
            timestamp = "18:33",
            likeCount = 5,
            isLiked = false,
        )
    }
}
