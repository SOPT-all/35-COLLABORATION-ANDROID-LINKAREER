package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.FilteringChip
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun InternMainTitle(
    blackTextFirst: String? = "",
    blueText: String,
    blackText: String,
    isMore: Boolean = false,
    chipList: List<String>? = null,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Absolute.spacedBy(4.dp),
                ) {
                    if (blackTextFirst != null) {
                        Text(
                            text = blackTextFirst,
                            style = LINKareerTheme.typography.title1B18,
                            color = LINKareerTheme.colors.black,
                        )
                    }
                    Text(
                        text = blueText,
                        style = LINKareerTheme.typography.title2B17,
                        color = LINKareerTheme.colors.blue,
                    )
                    Text(
                        text = blackText,
                        style = LINKareerTheme.typography.title1B18,
                        color = LINKareerTheme.colors.black,
                    )
                }
                if (isMore) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier =
                            Modifier
                                .noRippleClickable { }
                                .padding(vertical = 10.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.home_more_button),
                            style = LINKareerTheme.typography.body10M11,
                            color = LINKareerTheme.colors.gray800,
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_right_black_12),
                            contentDescription = null,
                            tint = LINKareerTheme.colors.gray800,
                        )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp),
            ) {
                if (!chipList.isNullOrEmpty()) {
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
    }
}

@Preview
@Composable
fun InternMainTitlePreview() {
    LINKareerAndroidTheme {
        InternMainTitle(
            blackTextFirst = "실시간",
            blueText = "UX/UI",
            blackText = "직무 기업 별 합격 가이드",
            chipList = listOf("전체", "인턴", "신입", "대기업", "공기업"),
            isMore = true,
            modifier = Modifier.padding(start = 17.dp, top = 28.dp, end = 17.dp, bottom = 12.dp),
        )
    }
}
