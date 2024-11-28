package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.component.chip.BlueOutlinedChip
import org.sopt.linkareer.core.designsystem.theme.Black
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun InternSubTitle(
    blueText: String,
    blackText: String,
    grayText: String,
    chipList: List<String>,
    onButtonClick: () -> Unit = {},
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
                Text(
                    text = blueText,
                    style = LINKareerTheme.typography.title2B17,
                    color = Blue,
                )
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
    }
}

@Preview
@Composable
fun InternSubTitlePreview() {
    LINKareerAndroidTheme {
        InternSubTitle(
            blueText = "UX/UI",
            blackText = "직무 합격 로드맵",
            grayText = "이(가) 언급되고 있어요.",
            chipList = listOf("유저 리서치", "사용자 조사", "UT"),
            onButtonClick = {},
            modifier = Modifier.padding(start = 17.dp, end = 17.dp, top = 32.dp, bottom = 12.dp),
        )
    }
}
