package org.sopt.linkareer.feature.chatroom.component

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Blue50
import org.sopt.linkareer.core.designsystem.Gray400
import org.sopt.linkareer.core.designsystem.Gray600
import org.sopt.linkareer.core.designsystem.Gray900
import org.sopt.linkareer.core.designsystem.defaultLINKareerTypography

@Composable
fun MyReplyChat(
    sender: String,
    receivedMessage: String,
    replyMessage: String,
    timestamp: String,
) {
    Column(
        modifier = Modifier
            .padding(end = 8.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = timestamp,
                style = defaultLINKareerTypography.body13R11,
                color = Gray600,
                modifier = Modifier
                    .padding(end = 4.dp)
            )
            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Blue50)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Bottom),
            ) {
                Text(
                    text = sender + " " + stringResource(R.string.chatroom_apply_to_sender),
                    style = defaultLINKareerTypography.body5B11,
                    color = Gray900
                )
                Text(
                    text = receivedMessage,
                    style = defaultLINKareerTypography.label3M11,
                    color = Gray600
                )

                HorizontalDivider(
                    color = Gray400,
                    thickness = 0.5.dp,
                )

                Text(
                    text = replyMessage,
                    style = defaultLINKareerTypography.body8M13,
                    color = Gray900
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.ic_chatting_like_inactive_25),
            contentDescription = stringResource(R.string.chatroom_reply_contentDescription),
            modifier = Modifier
                .padding(start = 30.dp, top = 4.dp),
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun MyReplyChatPreview(){
    MyReplyChat(
        sender = "nn",
        receivedMessage = "origin message",
        replyMessage = "text message",
        timestamp = "18:33",
    )
}
