package org.sopt.linkareer.feature.certification.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.LINKareerAndroidTheme

@Composable
fun CertificationTopBar(
    onIconClick: () -> Unit,
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.back_content_description),
            tint = Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationTopBarPreview() {
    LINKareerAndroidTheme {
        CertificationTopBar(
            onIconClick = {}
        )
    }
}