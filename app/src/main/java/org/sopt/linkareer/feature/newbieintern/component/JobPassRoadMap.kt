package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray200
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun JobPassRoadMap(
    subTitle: String,
    mainTitle: String,
    image: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .background(color = Gray200, shape = RoundedCornerShape(10.dp)),
    ) {
        Text(
            text = subTitle,
            style = LINKareerTheme.typography.label5M8,
            color = Gray600,
            modifier =
                Modifier
                    .padding(start = 12.dp, top = 16.dp, end = 15.dp),
        )
        Text(
            text = mainTitle,
            style = LINKareerTheme.typography.body5B11,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 12.dp, top = 2.dp),
        )
        Spacer(Modifier.height(7.dp))
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier =
                Modifier
                    .width(44.dp)
                    .height(44.dp)
                    .align(Alignment.End)
                    .padding(end = 4.dp, bottom = 12.dp),
        )
    }
}

@Preview
@Composable
fun JobPassRoadMapPreview() {
    LINKareerAndroidTheme {
        JobPassRoadMap(
            subTitle = "합격을 위한 꿀팁과 전략",
            mainTitle = "인/적성\n합격후기",
            image = R.drawable.img_newbie_liberalartsmentor,
        )
    }
}
