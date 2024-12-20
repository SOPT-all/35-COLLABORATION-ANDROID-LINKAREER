package org.sopt.linkareer.feature.chattingroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun OtherUserReplyChat(
    nickName: String,
    isChecked: Boolean,
    jobCategory: String,
    sender: String,
    receivedMessage: String,
    replyMessage: String,
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
        OtherUserReplyBubble(
            sender = sender,
            receivedMessage = receivedMessage,
            replyMessage = replyMessage,
            timestamp = timestamp,
        )
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

@Composable
fun OtherUserReplyBubble(
    sender: String,
    receivedMessage: String,
    replyMessage: String,
    timestamp: String,
) {
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
                    .width(IntrinsicSize.Max)
                    .widthIn(max = 230.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Blue50)
                    .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Bottom),
        ) {
            Text(
                text = stringResource(R.string.chatroom_apply_to_sender, sender),
                style = LINKareerTheme.typography.body5B11,
                color = Gray900,
            )
            Text(
                text = receivedMessage,
                style = LINKareerTheme.typography.label3M11,
                color = Gray600,
            )

            HorizontalDivider(
                color = Gray300,
                thickness = 1.dp,
            )

            Text(
                text = replyMessage,
                style = LINKareerTheme.typography.body8M13,
                color = Gray900,
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
}

@Composable
fun ChatJobChip(
    job: String,
    textColor: Color,
    backGroundColor: Color,
) {
    Box(
        modifier =
            Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(backGroundColor)
                .padding(5.dp),
    ) {
        Text(
            text = job,
            style = LINKareerTheme.typography.label5M8,
            color = textColor,
            modifier =
                Modifier
                    .wrapContentWidth(),
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable()
fun OtherUserReplyPreview() {
    LINKareerAndroidTheme {
        OtherUserReplyChat(
            nickName = "무관심한 맥",
            isChecked = true,
            jobCategory = "현대 자동차",
            sender = "아닌 삼백초",
            receivedMessage = "ppt 만들 때 예쁘게꾸며야 좋나요?",
            replyMessage = "굳이 꾸밀 필요없습니다.",
            timestamp = "18:33",
            likeCount = 5,
            isLiked = false,
        )
    }
}
