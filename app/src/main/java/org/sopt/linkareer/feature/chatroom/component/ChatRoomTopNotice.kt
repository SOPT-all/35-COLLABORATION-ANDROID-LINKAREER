package org.sopt.linkareer.feature.chatroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.defaultLINKareerTypography

@Composable
fun ChatRoomTopNotice() {
    Row(
      modifier =
        Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 44.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_megaphone_24),
            contentDescription = stringResource(R.string.chatroom_notice_megaphone),
            colorFilter = ColorFilter.tint(Blue)
        )
        Text(
            modifier = Modifier.padding(vertical = 2.dp),
            text = stringResource(R.string.chatroom_notice_top),
            style = defaultLINKareerTypography.label4M10
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