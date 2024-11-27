package org.sopt.linkareer.feature.chattingroom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun ChatLikeCount(
    likeCount: Int,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(38.dp))
                .border(
                    width = 1.dp,
                    color = Gray300,
                    shape = RoundedCornerShape(38.dp),
                )
                .background(White)
                .padding(vertical = 4.dp, horizontal = 5.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                imageVector =
                    if (isLiked) {
                        ImageVector.vectorResource(R.drawable.ic_thumbsup_blue_15)
                    } else {
                        ImageVector.vectorResource(R.drawable.ic_thumbsup_gray_15)
                    },
                contentDescription = stringResource(R.string.thumbs_up_activate),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = likeCount.toString(),
                style = LINKareerTheme.typography.body13R11,
                color = Gray700,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatLikeCountPreview() {
    ChatLikeCount(
        likeCount = 3,
        isLiked = false,
    )
}
