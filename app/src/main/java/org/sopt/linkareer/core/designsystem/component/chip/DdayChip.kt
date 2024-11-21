package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Black
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.White

@Composable
fun DdayChip(
    dDay: String,
    modifier: Modifier = Modifier,
) {
    ColourFilledBasicChip(
        text = stringResource(R.string.d_day, dDay),
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
            "1",
            modifier =
                Modifier
                    .padding(10.dp),
        )
    }
}
