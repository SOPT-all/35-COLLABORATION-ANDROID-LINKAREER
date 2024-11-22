package org.sopt.linkareer.core.designsystem.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarIconRow(
    iconList: List<Int>,
    iconSpacing: Dp = 0.dp,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(iconSpacing),
    ) {
        iconList.forEach { iconRes ->
            Image(
                imageVector = ImageVector.vectorResource(id = iconRes),
                contentDescription = null,
            )
        }
    }
}
