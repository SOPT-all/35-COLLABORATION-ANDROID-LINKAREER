package org.sopt.linkareer.core.designsystem.component.text

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.Blue
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.LINKareerTheme

@Composable
fun TextWithIcon(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_checkbadge_home_inperson_12),
            contentDescription = null,
        )
        Text(
            text = text,
            style = LINKareerTheme.typography.label5M8,
            color = Blue,
            modifier =
                Modifier
                    .padding(start = 2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextWithIconPreview() {
    LINKareerAndroidTheme {
        TextWithIcon(
            text = "현직자 대화중",
        )
    }
}
