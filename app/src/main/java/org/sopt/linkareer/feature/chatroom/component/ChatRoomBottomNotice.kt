package org.sopt.linkareer.feature.chatroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.Gray100
import org.sopt.linkareer.core.designsystem.Gray200
import org.sopt.linkareer.core.designsystem.Gray700
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.White
import org.sopt.linkareer.core.designsystem.defaultLINKareerTypography

@Composable
fun ChatRoomBottomNotice(
    onClickToCheck: () -> Unit,
    onClickDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Gray100)
            .border(
                1.dp,
                color = Gray200,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_certification_check_bottom),
                contentDescription = stringResource(R.string.chatroom_notice_contentDescription)
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Text(
                modifier = Modifier
                    .clickable { onClickToCheck() },
                text = stringResource(R.string.chatroom_notice_link),
                style = defaultLINKareerTypography.body11M10.copy(
                    textDecoration = TextDecoration.Underline
                ),
                color = Blue,
            )
            Text(
                text = stringResource(R.string.chatroom_notice_link_description),
                style = defaultLINKareerTypography.body11M10,
                color = Gray700,
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.ic_chatroom_close),
                contentDescription = null,
                Modifier
                    .clickable { onClickDelete() },
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable()
fun ChatRoomBottomNoticePreview() {
    LINKareerAndroidTheme {
        ChatRoomBottomNotice(
            onClickToCheck = {},
            onClickDelete = {}
        )
    }
}