package org.sopt.linkareer.feature.newbieintern.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
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
        modifier = Modifier
            .then(modifier)
            .background(color = Gray200, shape = RoundedCornerShape(10.dp)),

        ) {
        Text(
            text = subTitle,
            style = LINKareerTheme.typography.label5M8,
            color = Gray600,
            modifier = Modifier
                .padding(start = 12.dp, top = 16.dp, end = 15.dp)
        )
        Text(
            text = mainTitle,
            style = LINKareerTheme.typography.body5B11,
            color = Gray900,
            modifier =
            Modifier
                .padding(start = 12.dp, top = 2.dp)
        )
        AsyncImage(
            model = ImageVector.vectorResource(image),
            contentDescription = null,
            modifier =
            Modifier
                .padding(start = 55.dp, top = 7.dp, end = 4.dp, bottom = 12.dp)
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
            image = R.drawable.ex_jobpassroadmap
        )
    }
}