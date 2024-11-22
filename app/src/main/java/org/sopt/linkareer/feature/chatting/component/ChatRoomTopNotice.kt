package org.sopt.linkareer.feature.chatting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray200
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography

@Composable
fun ChatRoomTopNotice() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Gray200)
                .padding(start = 8.dp, end = 44.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_megaphone_32),
            contentDescription = stringResource(R.string.chatroom_notice_megaphone),
        )
        Text(
            text = stringResource(R.string.chatroom_notice_top),
            style = defaultLINKareerTypography.label4M10,
            color = Gray700,
            modifier =
                Modifier
                    .padding(vertical = 10.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable()
fun ChatRoomTopNoticePreview() {
    LINKareerAndroidTheme {
        ChatRoomTopNotice()
    }
}
