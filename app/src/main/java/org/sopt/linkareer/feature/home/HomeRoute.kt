package org.sopt.linkareer.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.feature.home.component.CommunityBest
import org.sopt.linkareer.feature.home.component.HomeBannerPager
import org.sopt.linkareer.feature.home.component.HomeTitle
import org.sopt.linkareer.feature.home.component.NoticeType
import org.sopt.linkareer.feature.home.component.RecommendationNotice

@Composable
fun HomeRoute(
    navigateToNewbieIntern: () -> Unit,
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getPosts("interest")
        viewModel.getOfficials("recommend")
    }

    HomeScreen(
        onTabClick = { navigateToNewbieIntern() },
        paddingValues,
        homeState,
        viewModel,
    )
}

@Composable
fun HomeScreen(
    onTabClick: (String) -> Unit,
    paddingValues: PaddingValues,
    homeState: HomeState,
    viewModel: HomeViewModel = hiltViewModel(),
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
                    onTabClick = onTabClick,
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
        if (homeState.postList is UiState.Success) {
            items(
                count = 3,
                key = { homeState.postList.data[it].id },
            ) { post ->
                with(homeState.postList.data[post]) {
                    CommunityBest(
                        community = community,
                        imageUrl = imageUrl,
                        title = title,
                        content = content,
                        writer = writer,
                        beforeTime = beforeTime,
                        favorites = favourites,
                        comments = comments,
                        views = views,
                        modifier =
                            Modifier
                                .padding(start = 15.dp, end = 19.dp),
                    )
                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = LINKareerTheme.colors.gray300,
                    modifier =
                        Modifier
                            .padding(start = 15.dp, end = 19.dp),
                )
            }
        }

        item {
            Column(
                modifier =
                    Modifier
                        .padding(top = 20.dp)
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
                    if (homeState.officialList is UiState.Success) {
                        items(
                            count = homeState.officialList.data.size,
                            key = { homeState.officialList.data[it].id },
                        ) { official ->
                            with(homeState.officialList.data[official]) {
                                RecommendationNotice(
                                    noticeType = NoticeType.LIST,
                                    imageUrl = imageUrl,
                                    title = title,
                                    companyName = companyName,
                                    tag = tag,
                                    views = views,
                                    comments = comments,
                                    dDay = dDay,
                                    isBookmarked = isBookmarked,
                                    onBookmarkClick = { bookmarked ->
                                        if (bookmarked) {
                                            viewModel.addBookmark(id, "recommend")
                                        } else {
                                            viewModel.removeBookmark(id, "recommend")
                                        }
                                    },
                                )
                            }
                        }
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
        HomeScreen(
            onTabClick = {},
            PaddingValues(1.dp),
            HomeState(),
        )
    }
}
