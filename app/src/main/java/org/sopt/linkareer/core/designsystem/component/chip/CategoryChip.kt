package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray800
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun CategoryChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = text,
        textColor = Gray800,
        backgroundColor = Gray300,
        paddingValues = PaddingValues(vertical = 2.dp, horizontal = 6.dp),
        cornerRadius = 4.dp,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryChipPreview() {
    LINKareerAndroidTheme {
        CategoryChip(
            text = "카테고리 칩",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
