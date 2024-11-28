package org.sopt.linkareer.feature.chattingroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray100
import org.sopt.linkareer.core.designsystem.theme.Gray200
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun ChatRoomBottomNotice(
    onClickToCheck: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isVisible by remember { mutableStateOf(true) }

    if (isVisible) {
        Box(
            modifier =
                modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Gray100)
                    .border(
                        1.dp,
                        color = Gray200,
                        shape = RoundedCornerShape(10.dp),
                    )
                    .padding(8.dp),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_certification_check_bottom),
                    contentDescription = stringResource(R.string.chatroom_notice_contentDescription),
                )
                Spacer(modifier = Modifier.padding(start = 4.dp))
                Text(
                    text = stringResource(R.string.chatroom_notice_link),
                    style =
                        LINKareerTheme.typography.body11M10.copy(
                            textDecoration = TextDecoration.Underline,
                        ),
                    color = Blue,
                    modifier =
                        Modifier
                            .noRippleClickable { onClickToCheck() },
                )
                Text(
                    text = stringResource(R.string.chatroom_notice_link_description),
                    style = LINKareerTheme.typography.body11M10,
                    color = Gray700,
                )
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.ic_chatroom_close),
                    contentDescription = null,
                    modifier =
                        Modifier
                            .noRippleClickable { isVisible = false },
                    // 이 뷰 닫기
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable()
fun ChatRoomBottomNoticePreview() {
    LINKareerAndroidTheme {
        ChatRoomBottomNotice(
            onClickToCheck = {},
        )
    }
}
