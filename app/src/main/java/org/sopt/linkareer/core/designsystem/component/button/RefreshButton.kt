package org.sopt.linkareer.core.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray300
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun RefreshButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            Modifier
                .then(modifier)
                .border(
                    border = BorderStroke(width = Dp.Hairline, color = Gray300),
                    shape = RoundedCornerShape(50.dp),
                )
                .padding(
                    top = 9.dp,
                    bottom = 8.dp,
                    start = 11.dp,
                    end = 12.dp,
                )
                .noRippleClickable { onClick() },
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_refresh_12),
            contentDescription = null,
            tint = Gray700,
        )
        Text(
            text = stringResource(R.string.chatting_home_refresh),
            style = LINKareerTheme.typography.label4M10,
            color = Gray700,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RefreshButtonPreview() {
    LINKareerAndroidTheme {
        RefreshButton(
            onClick = {},
        )
    }
}
