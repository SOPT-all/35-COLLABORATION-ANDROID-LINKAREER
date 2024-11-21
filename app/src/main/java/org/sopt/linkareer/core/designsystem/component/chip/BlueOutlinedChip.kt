package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme

@Composable
fun BlueOutlinedChip(
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
                .border(
                    border = BorderStroke(width = Dp.Hairline, color = Blue),
                    shape = RoundedCornerShape(4.dp),
                )
                .padding(vertical = 2.dp, horizontal = 6.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun BlueOutlinedChipPreview() {
    LINKareerAndroidTheme {
        BlueOutlinedChip(
            text = "부트캠프",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
