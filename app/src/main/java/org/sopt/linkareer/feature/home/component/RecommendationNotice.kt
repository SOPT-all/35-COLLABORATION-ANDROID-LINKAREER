package org.sopt.linkareer.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.BlueTextChip
import org.sopt.linkareer.core.designsystem.component.chip.DdayChip
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun RecommendationNotice(
    @DrawableRes imageUrl: Int,
    title: String,
    companyName: String,
    tag: String,
    views: Int,
    comments: Int,
    dDay: String,
    isBookmarked: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            Modifier
                .width(120.dp)
                .background(color = LINKareerTheme.colors.blue50),
    ) {
        RecommendationNoticeCardSection(
            imageUrl = imageUrl,
            dDay = dDay,
            isBookmarked = isBookmarked,
            modifier =
                Modifier
                    .aspectRatio(1f),
        )
        Spacer(Modifier.height(4.dp))

        Column(
            modifier = Modifier,
        ) {
            RecommendationNoticeCompany(companyName = companyName)
            RecommendationNoticeTitle(title = title)
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
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            Modifier
                .padding(bottom = 4.dp),
    ) {
        AsyncImage(
            model = imageUrl,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(color = LINKareerTheme.colors.gray100)
                    .align(Alignment.Center)
                    .aspectRatio(1f),
            contentDescription = null,
        )
        DdayChip(
            dDay = dDay,
            modifier =
                Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp, vertical = 10.dp),
        )
        val isBookmarkedRes =
            when (isBookmarked) {
                false -> R.drawable.ic_bookmark_white_36
                else -> R.drawable.ic_bookmark_full_36
            }
        Image(
            imageVector = ImageVector.vectorResource(isBookmarkedRes),
            contentDescription = null,
            modifier =
                Modifier
                    .align(Alignment.TopEnd),
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
) {
    Text(
        text = title,
        modifier = modifier,
        style = LINKareerTheme.typography.body5B11,
        color = LINKareerTheme.colors.gray900,
        maxLines = 2,
        minLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun RecommendationNoticeStatistics(
    views: Int,
    comments: Int,
) {
    Row {
        RecommendationNoticeStatisticsItem(stringResource(R.string.recommendation_notice_views), views)
        Spacer(Modifier.width(8.dp))
        RecommendationNoticeStatisticsItem(stringResource(R.string.recommendation_notice_comments), comments)
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
    LINKareerAndroidTheme {
        RecommendationNotice(
            imageUrl = R.drawable.img_hotofficial_lalasweet,
            title = "[LG CNS] [인턴_학사] 2025년 동계 DX Core 인...",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20384,
            comments = 342,
            dDay = "D-7",
            isBookmarked = false,
        )
    }
}
