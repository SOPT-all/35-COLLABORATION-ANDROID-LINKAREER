package org.sopt.linkareer.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.tapbar.HomeTapBar
import org.sopt.linkareer.core.designsystem.component.textfield.SearchTextField
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.feature.home.component.HomeTitle

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
) {
    HomeScreen(paddingValues)
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {
    Column(
        modifier =
            Modifier
                .padding(paddingValues),
    ) {
        var searchText by remember { mutableStateOf("") }

        SearchTextField(
            value = searchText,
            onValueChange = { searchText = it },
            hintText = stringResource(R.string.home_search_textfield_hint),
            modifier =
                Modifier
                    .background(Blue)
                    .padding(horizontal = 17.dp, vertical = 12.dp),
        )

        HomeTapBar(
            onTabClick = {},
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = Gray300,
        )

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Blue50)
        ) {
            HomeTitle(
                blueText = stringResource(R.string.home_title_name),
                blackText = stringResource(R.string.home_title_interest_announcement),
                grayText = stringResource(R.string.home_sub_title_interest_announcement),
                chipList =
                    listOf(
                        stringResource(R.string.home_chip_interest_announcement_1),
                        stringResource(R.string.home_chip_interest_announcement_2),
                        stringResource(R.string.home_chip_interest_announcement_3),
                    ),
                modifier =
                    Modifier
                        .padding(
                            start = 15.dp,
                            end = 17.dp,
                            top = 20.dp,
                            bottom = 8.dp,
                        ),
            )

            LazyRow {
                items(4) {
                    Box(
                        modifier = Modifier.size(width = 326.dp, height = 282.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LINKareerAndroidTheme {
        HomeScreen(PaddingValues(1.dp))
    }
}
