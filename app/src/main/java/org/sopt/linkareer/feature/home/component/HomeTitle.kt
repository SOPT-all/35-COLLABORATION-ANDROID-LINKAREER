package org.sopt.linkareer.feature.home.component

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
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.BlueOutlinedChip
import org.sopt.linkareer.core.designsystem.theme.Black
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray800
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun HomeTitle(
    blackText: String,
    grayText: String,
    chipList: List<String>,
    onButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    blueText: String? = null,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Column(
            modifier =
                Modifier
                    .weight(1f),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (blueText != null) {
                    Text(
                        text = blueText,
                        style = LINKareerTheme.typography.title2B17,
                        color = Blue,
                    )
                }
                Text(
                    text = blackText,
                    style = LINKareerTheme.typography.title1B18,
                    color = Black,
                    modifier =
                        Modifier
                            .padding(start = 4.dp),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp),
            ) {
                for (text in chipList) {
                    BlueOutlinedChip(
                        text = text,
                        modifier =
                            Modifier
                                .padding(end = 4.dp),
                    )
                }

                Text(
                    text = grayText,
                    style = LINKareerTheme.typography.body14R10,
                    color = Gray600,
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .padding(vertical = 4.dp)
                    .noRippleClickable { onButtonClick() }
                    .padding(vertical = 10.dp),
        ) {
            Text(
                text = stringResource(R.string.home_more_button),
                style = LINKareerTheme.typography.body10M11,
                color = Gray800,
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_right_black_12),
                contentDescription = null,
            )
        }
    }
}
