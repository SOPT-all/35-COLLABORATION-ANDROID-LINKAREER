package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray100
import org.sopt.linkareer.core.designsystem.theme.Gray200
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun CompanyPassGuide(
    companyImg: Int,
    companyName: String,
    personalStatementNum: Int,
    personalityNum: Int,
    interviewNum: Int,
    finalPassNum: Int,
) {
    val passGuideItems =
        listOf(
            PassGuideItem(personalStatementNum, stringResource(R.string.newbieintern_personal_statement)),
            PassGuideItem(personalityNum, stringResource(R.string.newbieintern_personality)),
            PassGuideItem(interviewNum, stringResource(R.string.newbieintern_interview)),
            PassGuideItem(finalPassNum, stringResource(R.string.newbieintern_final_pass)),
        )

    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(width = 1.dp, color = Gray300),
                shape = RoundedCornerShape(size = 8.dp),
            )
            .background(color = Gray100, shape = RoundedCornerShape(size = 8.dp))
            .padding(12.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(companyImg),
                contentDescription = null,
                modifier =
                Modifier
                    .background(color = White, shape = RoundedCornerShape(4.dp))
                    .height(54.dp)
                    .width(54.dp)
            )

            Text(
                text = companyName,
                modifier =
                Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                color = Gray900,
                style = LINKareerTheme.typography.body3B13,
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 11.dp),
            ) {
                Text(
                    text = stringResource(R.string.newbieintern_pass_guide_plus),
                    color = Gray600,
                    style = LINKareerTheme.typography.body13R11,
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_gray_12_),
                    contentDescription = null,
                    tint = Gray600,
                )
            }
        }

        HorizontalDivider(
            modifier =
            Modifier
                .padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Gray200,
        )

        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .height(44.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            passGuideItems.forEachIndexed { index, item ->
                PassGuideNum(item)
                if (index < passGuideItems.lastIndex) {
                    VerticalDivider(
                        thickness = 1.dp,
                        color = LINKareerTheme.colors.gray200,
                    )
                }
            }
        }
    }
}

data class PassGuideItem(
    val number: Int,
    val title: String,
)

@Composable
fun PassGuideNum(item: PassGuideItem) {
    Column(
        modifier =
        Modifier
            .padding(start = 23.dp, top = 4.dp, end = 22.dp, bottom = 4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = item.number.toString(),
            color = Gray900,
            style = LINKareerTheme.typography.body6M15,
        )
        Text(
            text = item.title,
            color = Gray700,
            style = LINKareerTheme.typography.body14R10,
        )
    }
}

@Preview
@Composable
fun CompanyPassGuidePreview() {
    LINKareerAndroidTheme {
        CompanyPassGuide(
            R.drawable.img_companypass_samsung_54,
            "삼성전자",
            10,
            7,
            0,
            2,
        )
    }
}
