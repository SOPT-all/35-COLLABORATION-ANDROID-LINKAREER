package org.sopt.linkareer.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.BlueTextChip
import org.sopt.linkareer.core.designsystem.component.chip.DdayChip
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

enum class NoticeType {
    BANNER,
    LIST,
}

@Composable
fun RecommendationNotice(
    noticeType: NoticeType,
    @DrawableRes imageUrl: Int,
    title: String,
    companyName: String,
    tag: String,
    views: Int,
    comments: Int,
    dDay: String,
    isBookmarked: Boolean,
    modifier: Modifier = Modifier,
    onBookmarkClick: (Boolean) -> Unit = {},
) {
    val width =
        when (noticeType) {
            NoticeType.BANNER -> 320.dp
            NoticeType.LIST -> 120.dp
        }
    val imagePadding = if (noticeType == NoticeType.BANNER) 0.dp else 16.dp
    val titleMaxLines = if (noticeType == NoticeType.BANNER) 1 else 2
    var bookmarkedState by remember { mutableStateOf(isBookmarked) }

    Column(
        modifier =
            modifier
                .width(width)
                .background(color = LINKareerTheme.colors.blue50),
    ) {
        RecommendationNoticeCardSection(
            imageUrl = imageUrl,
            dDay = dDay,
            isBookmarked = bookmarkedState,
            noticeType = noticeType,
            onBookmarkClick = {
                bookmarkedState = it
                onBookmarkClick(it)
            },
            modifier = Modifier.aspectRatio(1f),
            imagePaddingValues = imagePadding,
        )
        Spacer(Modifier.height(4.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            RecommendationNoticeCompany(companyName = companyName)
            RecommendationNoticeTitle(title = title, titleMaxLines = titleMaxLines)
            Spacer(Modifier.height(4.dp))
            BlueTextChip(text = tag)
            Spacer(Modifier.height(4.dp))
            RecommendationNoticeStatistics(views = views, comments = comments)
        }
    }
}

@Composable
fun RecommendationNoticeCardSection(
    @DrawableRes imageUrl: Int,
    dDay: String,
    isBookmarked: Boolean,
    noticeType: NoticeType,
    modifier: Modifier = Modifier,
    imagePaddingValues: Dp,
    onBookmarkClick: (Boolean) -> Unit,
) {
    Box(
        modifier = Modifier.padding(bottom = 4.dp),
    ) {
        AsyncImage(
            model = imageUrl,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = imagePaddingValues)
                    .background(color = LINKareerTheme.colors.gray100)
                    .align(Alignment.Center),
            contentDescription = null,
        )
        DdayChip(
            dDay = dDay,
            modifier =
                Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp, vertical = 10.dp),
        )
        val bookmarkIcon =
            when (noticeType) {
                NoticeType.BANNER ->
                    if (isBookmarked) {
                        R.drawable.ic_bookmark_full_black_36
                    } else {
                        R.drawable.ic_bookmark_black_36
                    }
                NoticeType.LIST ->
                    if (isBookmarked) {
                        R.drawable.ic_bookmark_full_white_36
                    } else {
                        R.drawable.ic_bookmark_white_36
                    }
            }

        Image(
            imageVector = ImageVector.vectorResource(bookmarkIcon),
            contentDescription = null,
            modifier =
                Modifier.align(Alignment.TopEnd)
                    .clickable { onBookmarkClick(!isBookmarked) },
        )
    }
}

@Composable
fun RecommendationNoticeCompany(
    companyName: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = companyName,
        modifier = modifier,
        style = LINKareerTheme.typography.body11M10,
        color = LINKareerTheme.colors.gray600,
    )
}

@Composable
fun RecommendationNoticeTitle(
    title: String,
    modifier: Modifier = Modifier,
    titleMaxLines: Int,
) {
    Text(
        text = title,
        modifier = modifier,
        style = LINKareerTheme.typography.body5B11,
        color = LINKareerTheme.colors.gray900,
        maxLines = titleMaxLines,
        minLines = titleMaxLines,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun RecommendationNoticeStatistics(
    views: Int,
    comments: Int,
) {
    Row {
        RecommendationNoticeStatisticsItem(
            stringResource(R.string.recommendation_notice_views),
            views,
        )
        Spacer(Modifier.width(8.dp))
        RecommendationNoticeStatisticsItem(
            stringResource(R.string.recommendation_notice_comments),
            comments,
        )
    }
}

@Composable
fun RecommendationNoticeStatisticsItem(
    text: String,
    count: Int,
) {
    Row {
        Text(
            text = text,
            style = LINKareerTheme.typography.label5M8,
            color = LINKareerTheme.colors.gray600,
        )
        Text(
            text = count.toString(),
            style = LINKareerTheme.typography.label5M8,
            color = LINKareerTheme.colors.gray600,
        )
    }
}

@Preview
@Composable
fun RecommendationNoticePreview() {
    RecommendationNotice(
        imageUrl = R.drawable.img_hotofficial_lalasweet,
        title = "[LG CNS] [인턴_학사] 2025년 동계 DX Core 인2025년 동계 DX Core 인....",
        companyName = "LG CNS",
        tag = "정규직 1차 면접 프리패스",
        views = 20384,
        comments = 342,
        dDay = "D-7",
        isBookmarked = false,
        noticeType = NoticeType.LIST,
    )
}
