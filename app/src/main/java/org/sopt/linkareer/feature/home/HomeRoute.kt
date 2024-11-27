package org.sopt.linkareer.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.FilteringChip
import org.sopt.linkareer.core.designsystem.component.footer.MainFooter
import org.sopt.linkareer.core.designsystem.component.tapbar.HomeTapBar
import org.sopt.linkareer.core.designsystem.component.textfield.SearchTextField
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.feature.home.component.HomeBannerPager
import org.sopt.linkareer.feature.home.component.HomeTitle

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    HomeScreen(paddingValues, homeState)
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    homeState: HomeState,
) {
    var searchText by remember { mutableStateOf("") }

    LazyColumn(
        modifier =
            Modifier
                .padding(paddingValues),
    ) {
        item {
            Column {
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
            }
        }
        item {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Blue50),
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
                HomeBannerPager(homeState.bannerList)
            }
        }
        item {
            HomeTitle(
                blueText = stringResource(R.string.home_title_name),
                blackText = stringResource(R.string.home_title_interest_people),
                grayText = stringResource(R.string.home_sub_title_interest_people),
                chipList =
                    listOf(
                        stringResource(R.string.home_chip_interest_people_1),
                        stringResource(R.string.home_chip_interest_people_2),
                        stringResource(R.string.home_chip_interest_people_3),
                    ),
                modifier =
                    Modifier
                        .padding(
                            start = 15.dp,
                            end = 17.dp,
                            top = 20.dp,
                            bottom = 6.dp,
                        ),
            )
        }
        items(3) {
            Box(
                modifier = Modifier.size(width = 326.dp, height = 132.dp),
            )
        }
        item {
            Column(
                modifier =
                    Modifier
                        .background(Blue50),
            ) {
                HomeTitle(
                    blueText = stringResource(R.string.home_title_name),
                    blackText = stringResource(R.string.home_title_recommend_announcement),
                    grayText = stringResource(R.string.home_sub_title_recommend_announcement),
                    chipList =
                        listOf(
                            stringResource(R.string.home_chip_recommend_announcement_1),
                            stringResource(R.string.home_chip_recommend_announcement_2),
                            stringResource(R.string.home_chip_recommend_announcement_3),
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
                Row(
                    modifier = Modifier.padding(start = 15.dp),
                ) {
                    FilteringChip(
                        text = stringResource(R.string.home_filtering_employment_news),
                        isSelected = true,
                    )
                    FilteringChip(
                        text = stringResource(R.string.home_filtering_activities),
                        isSelected = false,
                        modifier =
                            Modifier
                                .padding(start = 8.dp),
                    )
                }

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier =
                        Modifier
                            .padding(top = 12.dp, bottom = 40.dp),
                ) {
                    items(6) {
                        Box(
                            modifier =
                                Modifier
                                    .size(width = 120.dp, height = 216.dp)
                                    .background(Blue),
                        )
                    }
                }
            }
            MainFooter()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LINKareerAndroidTheme {
        HomeScreen(PaddingValues(1.dp), HomeState())
    }
}
