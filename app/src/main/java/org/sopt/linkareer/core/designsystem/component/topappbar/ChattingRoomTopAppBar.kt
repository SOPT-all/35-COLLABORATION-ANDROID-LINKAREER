package org.sopt.linkareer.core.designsystem.component.topappbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import okhttp3.internal.immutableListOf
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun BackChattingRoomTopAppBar(
    chattingRoomName: String,
    chattingRoomHeadCount: Int,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackTopAppBar(
        onBackButtonClick = onBackButtonClick,
        appBarAdditionContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = chattingRoomName,
                    modifier = Modifier.padding(1.dp),
                    color = Gray900,
                    style = LINKareerTheme.typography.title4B15,
                )
                Text(
                    text = stringResource(id = R.string.topappbar_chatting_room_head_count, chattingRoomHeadCount.toString()),
                    modifier =
                        Modifier
                            .padding(start = 1.dp, top = 2.dp, bottom = 2.dp)
                            .weight(1f),
                    color = Gray600,
                    style = LINKareerTheme.typography.body7M14,
                )
                TopAppBarIconRow(iconList = backChattingRoomTopAppBarIcons, iconSpacing = 8.dp)
            }
        },
    )
}

val backChattingRoomTopAppBarIcons =
    immutableListOf(
        R.drawable.ic_alert_24,
        R.drawable.ic_search_24,
        R.drawable.ic_kebapmenu_black_24,
    )

@Preview
@Composable
fun BackChattingRoomTopAppBarPreview() {
    LINKareerAndroidTheme {
        BackChattingRoomTopAppBar(
            chattingRoomName = "현대자동차",
            chattingRoomHeadCount = 1294,
            onBackButtonClick = {},
        )
    }
}
