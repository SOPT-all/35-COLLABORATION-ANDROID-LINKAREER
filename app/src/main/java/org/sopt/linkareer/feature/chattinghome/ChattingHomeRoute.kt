package org.sopt.linkareer.feature.chattinghome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.textfield.SearchTextField
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable
import org.sopt.linkareer.domain.model.ChattingRoomEntity
import org.sopt.linkareer.feature.chattinghome.component.ChattingHomeEmptyRoom
import org.sopt.linkareer.feature.chattinghome.component.ChattingHomeRoomListItem
import org.sopt.linkareer.feature.chattinghome.component.ChattingHomeTabRow

@Composable
fun ChattingHomeRoute(
    paddingValues: PaddingValues,
    navigateToChattingRoom: () -> Unit,
    chattingHomeViewModel: ChattingHomeViewModel = hiltViewModel(),
) {
    val chattingHomeState = chattingHomeViewModel.chattingHomeState.collectAsStateWithLifecycle()

    with(chattingHomeState.value) {
        ChattingHomeScreen(
            paddingValues = paddingValues,
            searchText = searchText,
            isMyChattingRoom = isMyChattingRoom,
            chattingRoomTab = chattingRoomTab,
            chattingRoomList = chattingRoomList,
            onSearchTextChange = chattingHomeViewModel::updateSearchText,
            onMyChattingRoomClick = chattingHomeViewModel::updateIsMyChattingRoom,
            onChattingRoomTabClick = chattingHomeViewModel::updateChattingRoomTab,
            navigateToChattingRoom = navigateToChattingRoom,
        )
    }
}

@Composable
fun ChattingHomeScreen(
    paddingValues: PaddingValues,
    searchText: String,
    isMyChattingRoom: Boolean,
    chattingRoomTab: Int,
    chattingRoomList: List<ChattingRoomEntity>,
    onSearchTextChange: (String) -> Unit,
    onMyChattingRoomClick: (Boolean) -> Unit,
    onChattingRoomTabClick: (Int) -> Unit,
    navigateToChattingRoom: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(paddingValues),
    ) {
        SearchTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            hintText = stringResource(R.string.chatting_home_search_textfield_hint),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Blue)
                    .padding(vertical = 12.dp, horizontal = 17.dp),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.chatting_home_my_chatting_room),
                style = if (isMyChattingRoom) LINKareerTheme.typography.title4B15 else LINKareerTheme.typography.body6M15,
                color = if (isMyChattingRoom) Gray900 else Gray600,
                modifier =
                    Modifier
                        .padding(start = 16.dp, top = 8.dp)
                        .noRippleClickable { onMyChattingRoomClick(true) }
                        .padding(vertical = 9.dp, horizontal = 4.dp),
            )

            Text(
                text = stringResource(R.string.chatting_home_all_chatting_room),
                style = if (!isMyChattingRoom) LINKareerTheme.typography.title4B15 else LINKareerTheme.typography.body6M15,
                color = if (!isMyChattingRoom) Gray900 else Gray600,
                modifier =
                    Modifier
                        .padding(start = 4.dp, top = 8.dp)
                        .noRippleClickable { onMyChattingRoomClick(false) }
                        .padding(vertical = 9.dp, horizontal = 4.dp),
            )
        }
        ChattingHomeTabRow(
            currentSelected = chattingRoomTab,
            onClick = onChattingRoomTabClick,
            modifier = Modifier.padding(top = 2.dp),
        )
        if (!isMyChattingRoom || chattingRoomTab in 0..1) {
            Text(
                text = stringResource(R.string.chatting_home_count, chattingRoomList.size),
                style = LINKareerTheme.typography.body10M11,
                color = LINKareerTheme.colors.gray700,
                modifier =
                    Modifier
                        .padding(vertical = 12.dp)
                        .padding(start = 16.dp),
            )

            ChattingHomeRoomListItem(chattingRoomList, navigateToChattingRoom)
        } else {
            ChattingHomeEmptyRoom(
                modifier =
                    Modifier
                        .padding(vertical = 24.dp, horizontal = 17.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChattingHomeScreenPreview() {
    LINKareerAndroidTheme {
        ChattingHomeScreen(
            paddingValues = PaddingValues(bottom = 32.dp),
            navigateToChattingRoom = {},
            searchText = "",
            isMyChattingRoom = true,
            chattingRoomTab = 0,
            chattingRoomList = listOf(),
            onSearchTextChange = {},
            onMyChattingRoomClick = {},
            onChattingRoomTabClick = {},
        )
    }
}
