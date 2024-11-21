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
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.Blue100
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme

@Composable
fun BlueTextChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = LINKareerTheme.typography.label5M8,
        color = Blue,
        modifier =
            Modifier
                .then(modifier)
                .clip(RoundedCornerShape(4.dp))
                .background(Blue100)
                .padding(4.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun BlueTextChipPreview() {
    LINKareerAndroidTheme {
        BlueTextChip(
            text = "테스트",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
