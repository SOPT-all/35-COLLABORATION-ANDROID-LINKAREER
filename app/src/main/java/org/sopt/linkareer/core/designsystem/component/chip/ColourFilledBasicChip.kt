package org.sopt.linkareer.core.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.LINKareerTheme

@Composable
fun ColourFilledBasicChip(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    paddingValues: PaddingValues,
    cornerRadius: Dp = 0.dp,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = LINKareerTheme.typography.label5M8,
        color = textColor,
        modifier =
            Modifier
                .then(modifier)
                .clip(RoundedCornerShape(cornerRadius))
                .background(backgroundColor)
                .padding(paddingValues),
    )
}
