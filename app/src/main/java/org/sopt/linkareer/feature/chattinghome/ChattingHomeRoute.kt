package org.sopt.linkareer.feature.chattinghome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.textfield.SearchTextField
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun ChattingHomeRoute(
    paddingValues: PaddingValues,
    navigateToChattingRoom: () -> Unit,
) {
    ChattingHomeScreen(
        paddingValues,
        navigateToChattingRoom,
    )
}

@Composable
fun ChattingHomeScreen(
    paddingValues: PaddingValues,
    navigateToChattingRoom: () -> Unit,
) {
    var searchText by remember { mutableStateOf("") }
    var currentTab by remember { mutableStateOf("my") }

    Column(
        modifier = Modifier.padding(paddingValues),
    ) {
        SearchTextField(
            value = searchText,
            onValueChange = { searchText = it },
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
                style = if (currentTab == "my") LINKareerTheme.typography.title4B15 else LINKareerTheme.typography.body6M15,
                color = if (currentTab == "my") Gray900 else Gray600,
                modifier =
                    Modifier
                        .padding(start = 16.dp, top = 8.dp)
                        .noRippleClickable { currentTab = "my" }
                        .padding(vertical = 9.dp, horizontal = 4.dp),
            )

            Text(
                text = stringResource(R.string.chatting_home_all_chatting_room),
                style = if (currentTab == "all") LINKareerTheme.typography.title4B15 else LINKareerTheme.typography.body6M15,
                color = if (currentTab == "all") Gray900 else Gray600,
                modifier =
                    Modifier
                        .padding(start = 4.dp, top = 8.dp)
                        .noRippleClickable { currentTab = "all" }
                        .padding(vertical = 9.dp, horizontal = 4.dp),
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
        )
    }
}
