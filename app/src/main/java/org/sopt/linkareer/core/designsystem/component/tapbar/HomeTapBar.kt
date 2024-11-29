package org.sopt.linkareer.core.designsystem.component.tapbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun HomeTapBar(
    onTabClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    navigateToNewbieIntern: () -> Unit,
) {
    val newbieTab = stringResource(R.string.home_tab_newbie)
    var rememberTap by remember { mutableStateOf<String?>(null) }

    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(White)
                .padding(start = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier =
                Modifier
                    .weight(1f),
        ) {
            item {
                TabItem(
                    tapName = newbieTab,
                    isSelected = rememberTap == newbieTab,
                    onClick = {
                        rememberTap = newbieTab
                        onTabClick(newbieTab)
                        navigateToNewbieIntern()
                    },
                )
            }
            item {
                val contestTab = stringResource(R.string.home_tab_contest)
                TabItem(
                    tapName = contestTab,
                    isSelected = rememberTap == contestTab,
                    onClick = {
                        rememberTap = contestTab
                        onTabClick(contestTab)
                    },
                )
            }
            item {
                val channelTab = stringResource(R.string.home_tab_channel)
                TabItem(
                    tapName = channelTab,
                    isSelected = rememberTap == channelTab,
                    onClick = {
                        rememberTap = channelTab
                        onTabClick(channelTab)
                    },
                )
            }
            item {
                val communityTab = stringResource(R.string.home_tab_community)
                TabItem(
                    tapName = communityTab,
                    isSelected = rememberTap == communityTab,
                    onClick = {
                        rememberTap = communityTab
                        onTabClick(communityTab)
                    },
                )
            }
        }
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_box_30),
            contentDescription = stringResource(R.string.newbie_tab_arrow_down_contentDescription),
            modifier =
                Modifier
                    .padding(start = 8.dp, end = 10.dp),
        )
    }
}

@Composable
fun TabItem(
    tapName: String,
    isSelected: Boolean,
    onClick: () -> Unit = {},
) {
    Box(
        modifier =
            Modifier
                .noRippleClickable { onClick() }
                .width(IntrinsicSize.Max)
                .drawBehind {
                    if (isSelected) {
                        drawLine(
                            color = Blue,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 2.dp.toPx(),
                        )
                    }
                },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = tapName,
            style = defaultLINKareerTypography.title5B14,
            color = if (isSelected) Blue else Gray900,
            modifier =
                Modifier
                    .padding(vertical = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTapBarPreview() {
    LINKareerAndroidTheme {
        HomeTapBar(
            onTabClick = {},
            navigateToNewbieIntern = {},
        )
    }
}
