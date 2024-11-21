package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.Gray300
import org.sopt.linkareer.core.designsystem.Gray600
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme

@Composable
fun CommunityNameChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = LINKareerTheme.typography.label5M8,
        color = Gray600,
        modifier =
            Modifier
                .then(modifier)
                .clip(RoundedCornerShape(4.dp))
                .background(Gray300)
                .padding(4.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun CommunityNameChipPreview() {
    LINKareerAndroidTheme {
        CommunityNameChip(
            text = "커뮤니티 이름",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
