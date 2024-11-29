package org.sopt.linkareer.feature.newbieintern

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.button.RefreshButton
import org.sopt.linkareer.core.designsystem.component.chattingroom.ChattingRoomInPerson
import org.sopt.linkareer.core.designsystem.component.chip.FilteringChip
import org.sopt.linkareer.core.designsystem.component.footer.MainFooter
import org.sopt.linkareer.core.designsystem.component.tapbar.HomeTapBar
import org.sopt.linkareer.core.designsystem.component.tapbar.InternTapBar
import org.sopt.linkareer.core.designsystem.component.textfield.SearchTextField
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Blue50
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.RoadMapEntity
import org.sopt.linkareer.feature.home.HomeState
import org.sopt.linkareer.feature.home.HomeViewModel
import org.sopt.linkareer.feature.home.component.CommunityBest
import org.sopt.linkareer.feature.home.component.HomeTitle
import org.sopt.linkareer.feature.home.component.NoticeType
import org.sopt.linkareer.feature.home.component.RecommendationNotice
import org.sopt.linkareer.feature.newbieintern.component.CompanyPassGuide
import org.sopt.linkareer.feature.newbieintern.component.InternMainTitle
import org.sopt.linkareer.feature.newbieintern.component.InternSubTitle
import org.sopt.linkareer.feature.newbieintern.component.JobPassRoadMap

@Composable
fun NewbieInternRoute(
    navigateBack: () -> Unit,
    navigateToChattingRoom: () -> Unit,
    paddingValues: PaddingValues,
    newbieInternViewModel: NewbieInternViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val newbieInternState by newbieInternViewModel.newbieInternState.collectAsStateWithLifecycle()
    val homeState by homeViewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        homeViewModel.getPosts("interest")
        homeViewModel.getOfficials("recommend")
    }

    NewbieInternScreen(
        navigateToChattingRoom = navigateToChattingRoom,
        paddingValues = paddingValues,
        newbieInternState = newbieInternState,
        homeState = homeState,
        homeViewModel = homeViewModel,
    )
}

@Composable
fun NewbieInternScreen(
    navigateToChattingRoom: () -> Unit,
    paddingValues: PaddingValues,
    newbieInternState: NewbieInternState,
    homeState: HomeState,
    homeViewModel: HomeViewModel = hiltViewModel(),
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
                    navigateToNewbieIntern = {},
                )

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Gray300,
                )
                InternTapBar()
            }
        }
        item {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Blue50),
            ) {
                InternMainTitle(
                    blackTextFirst = stringResource(R.string.intern_official_title),
                    blueText = stringResource(R.string.intern_official_title_2),
                    blackText = stringResource(R.string.intern_official_title_3),
                    chipList =
                        listOf(
                            stringResource(R.string.intern_official_chip_1),
                            stringResource(R.string.intern_official_chip_2),
                            stringResource(R.string.intern_official_chip_3),
                            stringResource(R.string.intern_official_chip_4),
                            stringResource(R.string.intern_official_chip_5),
                        ),
                    isMore = true,
                    modifier = Modifier.padding(start = 17.dp, top = 28.dp, end = 17.dp, bottom = 12.dp),
                )
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier =
                        Modifier
                            .padding(top = 12.dp, bottom = 16.dp),
                ) {
                    if (homeState.officialList is UiState.Success) {
                        items(
                            count = homeState.officialList.data.size,
                            key = { homeState.officialList.data[it].id },
                        ) { official ->
                            with(homeState.officialList.data[official]) {
                                val isBookmarked =
                                    when (homeState.bookmarkStatus) {
                                        is UiState.Success -> homeState.bookmarkStatus.data[id] ?: false
                                        else -> false
                                    }
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
                                            homeViewModel.addBookmark(id)
                                        } else {
                                            homeViewModel.removeBookmark(id)
                                        }
                                    },
                                )
                            }
                        }
                    }
                }
            }
        }
        item {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(LINKareerTheme.colors.white),
            ) {
                InternSubTitle(
                    blueText = stringResource(R.string.intern_road_map_title),
                    blackText = stringResource(R.string.intern_road_map_title_2),
                    grayText = stringResource(R.string.intern_road_map_chip_mention),
                    chipList =
                        listOf(
                            stringResource(R.string.intern_road_map_chip_1),
                            stringResource(R.string.intern_road_map_chip_2),
                            stringResource(R.string.intern_road_map_chip_3),
                        ),
                    modifier = Modifier.padding(start = 17.dp, end = 17.dp, top = 32.dp),
                )
                Column(
                    modifier =
                        Modifier
                            .padding(top = 12.dp, start = 17.dp, end = 17.dp),
                ) {
                    Text(
                        text = stringResource(R.string.intern_road_map_pass),
                        style = LINKareerTheme.typography.body3B13,
                        color = LINKareerTheme.colors.gray800,
                    )
                    JobPassRoadMapRow(
                        roadMapList = newbieInternState.roadMapList.subList(0, 3),
                        modifier =
                            Modifier
                                .padding(top = 8.dp),
                    )

                    Spacer(Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.intern_road_map_question),
                        style = LINKareerTheme.typography.body3B13,
                        color = LINKareerTheme.colors.gray800,
                    )
                    JobPassRoadMapRow(
                        roadMapList = newbieInternState.roadMapList.subList(3, 6),
                        modifier = Modifier.padding(top = 8.dp),
                    )
                }
            }
        }

        item {
            InternMainTitle(
                blueText = stringResource(R.string.intern_official_title_2),
                blackText = stringResource(R.string.intern_official_title_3),
                isMore = true,
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
        items(
            count = 3,
            key = { "${newbieInternState.passGuideList[it].id}_passGuide_$it" },
        ) { guide ->
            with(newbieInternState.passGuideList[guide]) {
                CompanyPassGuide(
                    companyImg = companyImg,
                    companyName = companyName,
                    personalStatementNum = personalStatementNum,
                    personalityNum = personalityNum,
                    interviewNum = interviewNum,
                    finalPassNum = finalPassNum,
                    modifier =
                        Modifier
                            .padding(start = 15.dp, end = 19.dp, bottom = 8.dp),
                )
            }
        }

        item {
            HomeTitle(
                blackText = stringResource(R.string.intern_community_title),
                grayText = stringResource(R.string.intern_community_chip_mention),
                chipList =
                    listOf(
                        stringResource(R.string.intern_community_chip_1),
                        stringResource(R.string.intern_community_chip_2),
                        stringResource(R.string.intern_community_chip_3),
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

            // Todo :  padding 설정 재확인
            CommunityChipList(
                chipList =
                    listOf(
                        stringResource(R.string.intern_community_chip_4),
                        stringResource(R.string.intern_community_chip_5),
                        stringResource(R.string.intern_community_chip_6),
                    ),
            )
        }
        if (homeState.postList is UiState.Success) {
            items(
                count = homeState.postList.data.size,
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
            HomeTitle(
                blueText = stringResource(R.string.intern_official_title_2),
                blackText = stringResource(R.string.intern_chatting_title),
                grayText = stringResource(R.string.intern_chatting_chip_mention),
                chipList =
                    listOf(
                        stringResource(R.string.intern_chatting_chip_1),
                        stringResource(R.string.intern_chatting_chip_2),
                        stringResource(R.string.intern_chatting_chip_3),
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
        items(
            count = 3,
            key = { "${newbieInternState.chattingRoomList[it].id}_chatting$it" },
        ) { chat ->
            with(newbieInternState.chattingRoomList[chat]) {
                ChattingRoomInPerson(
                    image = companyImage,
                    categories = categories,
                    company = company,
                    chattingTitle = title,
                    participationPerson = participation,
                    // Todo : 성민오빠 채팅방으로
                    onClick = navigateToChattingRoom,
                    isInPersonConversation = isInPerson,
                    modifier =
                        Modifier
                            .padding(start = 15.dp, end = 19.dp, bottom = 8.dp),
                )
            }
        }
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                contentAlignment = Alignment.Center,
            ) {
                RefreshButton(
                    onClick = {},
                )
            }
        }
        item {
            MainFooter()
        }
    }
}

@Composable
fun JobPassRoadMapRow(
    roadMapList: List<RoadMapEntity>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            Modifier
                .then(modifier)
                .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        for (roadMap in roadMapList) {
            JobPassRoadMap(
                subTitle = roadMap.subTitle,
                mainTitle = roadMap.mainTitle,
                image = roadMap.image,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun CommunityChipList(chipList: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp, bottom = 12.dp, start = 15.dp),
    ) {
        if (chipList.isNotEmpty()) {
            for ((index, text) in chipList.withIndex()) {
                FilteringChip(
                    text = text,
                    isSelected = index == 0,
                    modifier =
                        Modifier
                            .padding(end = 8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun NewbieInternScreenPreview() {
    LINKareerAndroidTheme {
        NewbieInternScreen(
            navigateToChattingRoom = {},
            PaddingValues(1.dp),
            NewbieInternState(),
            HomeState(),
        )
    }
}
