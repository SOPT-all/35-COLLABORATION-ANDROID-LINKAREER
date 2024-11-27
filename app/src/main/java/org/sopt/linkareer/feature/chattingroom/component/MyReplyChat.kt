package org.sopt.linkareer.feature.chattingroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun MyReplyChat(
    sender: String,
    receivedMessage: String,
    replyMessage: String,
    timestamp: String,
    likeCount: Int,
    isLiked: Boolean,
) {
    Column(
        modifier =
            Modifier
                .padding(end = 9.dp),
        horizontalAlignment = Alignment.End,
    ) {
        Row(
            modifier =
                Modifier
                    .wrapContentWidth(),
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = timestamp,
                style = LINKareerTheme.typography.body13R11,
                color = Gray600,
                modifier =
                    Modifier
                        .padding(end = 4.dp),
            )
            Column(
                modifier =
                    Modifier
                        .width(IntrinsicSize.Max)
                        .widthIn(max = 230.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Blue50)
                        .padding(vertical = 12.dp, horizontal = 13.dp),
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
                    modifier =
                        Modifier
                            .padding(top = 7.dp),
                )

                HorizontalDivider(
                    color = Gray300,
                    thickness = 1.dp,
                    modifier =
                        Modifier
                            .padding(top = 9.dp),
                )

                Text(
                    text = replyMessage,
                    style = LINKareerTheme.typography.body8M13,
                    color = Gray900,
                    modifier =
                        Modifier
                            .padding(top = 9.dp),
                )
            }
        }
        if (isLiked || likeCount > 0) {
            ChatLikeCount(
                likeCount = likeCount,
                isLiked = isLiked,
                modifier =
                    Modifier
                        .padding(start = 30.dp, top = 4.dp),
            )
        } else {
            Image(
                painter = painterResource(R.drawable.ic_chatting_like_inactive_25),
                contentDescription = stringResource(R.string.chatroom_reply_contentDescription),
                modifier =
                    Modifier
                        .padding(start = 30.dp, top = 3.dp),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun MyReplyChatPreview() {
    MyReplyChat(
        sender = "nn",
        receivedMessage = "origin message",
        replyMessage = "text message",
        timestamp = "18:33",
        likeCount = 5,
        isLiked = false,
    )
}
