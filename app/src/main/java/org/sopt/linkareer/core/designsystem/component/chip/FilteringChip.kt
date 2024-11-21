package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.Gray300
import org.sopt.linkareer.core.designsystem.Gray900
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme
import org.sopt.linkareer.core.designsystem.White

@Composable
fun FilteringChip(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = text,
        textColor = if (isSelected) White else Gray900,
        backgroundColor = if (isSelected) Blue else Gray300,
        paddingValues = PaddingValues(vertical = 8.dp, horizontal = 13.dp),
        cornerRadius = 50.dp,
        textStyle = LINKareerTheme.typography.body10M11,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun SelectedFilterChipPreview() {
    LINKareerAndroidTheme {
        Column {
            FilteringChip(
                text = "채용 공고",
                isSelected = true,
                modifier =
                    Modifier
                        .padding(10.dp),
            )

            FilteringChip(
                text = "채용 공고",
                isSelected = false,
                modifier =
                    Modifier
                        .padding(10.dp),
            )
        }
    }
}
