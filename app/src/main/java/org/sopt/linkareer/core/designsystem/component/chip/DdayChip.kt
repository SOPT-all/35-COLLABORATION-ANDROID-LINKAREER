package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.theme.Black
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun DdayChip(
    dDay: String,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = dDay,
        textColor = White,
        backgroundColor = Black,
        paddingValues = PaddingValues(vertical = 2.dp, horizontal = 6.dp),
        cornerRadius = 4.dp,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun DdayChipPreview() {
    LINKareerAndroidTheme {
        DdayChip(
            "D - 1",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
