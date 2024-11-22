package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Blue100
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun BlueTextChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = text,
        textColor = Blue,
        backgroundColor = Blue100,
        paddingValues = PaddingValues(4.dp),
        cornerRadius = 4.dp,
        modifier = modifier,
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
