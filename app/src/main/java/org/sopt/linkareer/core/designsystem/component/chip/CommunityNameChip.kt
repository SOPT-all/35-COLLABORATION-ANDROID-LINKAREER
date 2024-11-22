package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun CommunityNameChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = text,
        textColor = Gray600,
        backgroundColor = Gray300,
        paddingValues = PaddingValues(4.dp),
        cornerRadius = 4.dp,
        modifier = modifier,
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
