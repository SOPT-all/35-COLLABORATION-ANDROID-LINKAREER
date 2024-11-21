package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Black
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme
import org.sopt.linkareer.core.designsystem.White

@Composable
fun DdayChip(
    dDay: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(R.string.d_day, dDay),
        style = LINKareerTheme.typography.label5M8,
        color = White,
        modifier =
            Modifier
                .then(modifier)
                .clip(RoundedCornerShape(4.dp))
                .background(Black)
                .padding(vertical = 2.dp, horizontal = 6.dp)
                .clip(RoundedCornerShape(4.dp)),
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
