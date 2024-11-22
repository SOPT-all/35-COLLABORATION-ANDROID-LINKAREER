package org.sopt.linkareer.feature.certification.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun CertificationTopBar(
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Icon(
            modifier =
                Modifier
                    .padding(horizontal = 17.dp, vertical = 10.dp),
            painter = painterResource(R.drawable.ic_arrow_left_24),
            contentDescription = stringResource(R.string.back_content_description),
            tint = Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationTopBarPreview() {
    LINKareerAndroidTheme {
        CertificationTopBar(
            onIconClick = {},
        )
    }
}
