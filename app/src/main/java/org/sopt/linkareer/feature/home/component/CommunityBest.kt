package org.sopt.linkareer.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.CommunityNameChip
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun CommunityBest(
    community: String,
    imageUrl: String,
    title: String,
    content: String,
    writer: String,
    beforeTime: String,
    favorites: Int,
    comments: Int,
    views: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .background(color = LINKareerTheme.colors.gray100)
                .padding(horizontal = 8.dp, vertical = 12.dp),
    ) {
        CommunityNameChip(text = community)
        Row(
            modifier =
                Modifier
                    .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(),
            ) {
                PostTitle(title = title)
                PostContent(content = content)
                PostAuthorInfo(writer = writer, beforeTime = beforeTime)
            }
            Spacer(Modifier.width(8.dp))
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(54.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .padding(vertical = 3.dp),
            )
        }
        Spacer(Modifier.height(8.dp))
        Row {
            PostStatistics(favorites, comments, views)
        }
    }
}

@Composable
fun PostTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(bottom = 4.dp),
        style = LINKareerTheme.typography.body3B13,
        color = LINKareerTheme.colors.gray900,
    )
}

@Composable
fun PostContent(content: String) {
    Text(
        text = content,
        modifier = Modifier.padding(bottom = 4.dp),
        style = LINKareerTheme.typography.body13R11,
        color = LINKareerTheme.colors.gray800,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun PostAuthorInfo(
    writer: String,
    beforeTime: String,
) {
    Row {
        Text(
            text = writer,
            modifier = Modifier.padding(end = 8.dp),
            style = LINKareerTheme.typography.label4M10,
            color = LINKareerTheme.colors.gray600,
        )
        Text(
            text = beforeTime,
            style = LINKareerTheme.typography.label4M10,
            color = LINKareerTheme.colors.gray600,
        )
    }
}

@Composable
fun PostStatistics(
    favorites: Int,
    comments: Int,
    views: Int,
) {
    Row {
        StatisticsItem(iconRes = R.drawable.ic_thumbsup_commu_gray_12, favorites)
        StatisticsItem(iconRes = R.drawable.ic_coment_commu_gray_12, comments)
        StatisticsItem(iconRes = R.drawable.ic_view_commu_gray_12, views)
    }
}

@Composable
fun StatisticsItem(
    @DrawableRes iconRes: Int,
    count: Int,
) {
    Row(
        modifier =
            Modifier
                .padding(end = 6.dp),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = count.toString(),
            style = LINKareerTheme.typography.label5M8,
            color = LINKareerTheme.colors.gray600,
        )
    }
}

@Preview
@Composable
fun CommunityBestPreview() {
    LINKareerAndroidTheme {
        CommunityBest(
            community = "면접 합격 후기",
            imageUrl = "",
            title = "하나은행 2차 면접 합격 후기입니다",
            content = "우선 대기실에 도착하면 안내 분들께서 친절히 자리를...우선 대기실에 도착하면 안내 분들께서 친절히 자리를...",
            writer = "문과출신",
            beforeTime = "2시간 전",
            favorites = 384,
            comments = 64,
            views = 6546,
        )
    }
}
