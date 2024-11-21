package org.sopt.linkareer.feature.chatroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import org.sopt.linkareer.core.designsystem.Blue50
import org.sopt.linkareer.core.designsystem.Gray600
import org.sopt.linkareer.core.designsystem.Gray900
import org.sopt.linkareer.core.designsystem.defaultLINKareerTypography

@Composable
fun MyChat(
    sendMessage: String,
    timestamp: String,
) {
    Column(
        modifier =
            Modifier
                .padding(end = 8.dp),
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
                style = defaultLINKareerTypography.body13R11,
                color = Gray600,
                modifier =
                    Modifier
                        .padding(end = 4.dp),
            )
            Column(
                modifier =
                    Modifier
                        .width(IntrinsicSize.Max)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Blue50)
                        .padding(12.dp),
            ) {
                Text(
                    text = sendMessage,
                    style = defaultLINKareerTypography.body8M13,
                    color = Gray900,
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.ic_chatting_like_inactive_25),
            contentDescription = stringResource(R.string.chatroom_reply_contentDescription),
            modifier =
                Modifier
                    .padding(start = 30.dp, top = 4.dp),
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun MyChatPreview() {
    MyChat(
        sendMessage = "text message",
        timestamp = "18:33",
    )
}
