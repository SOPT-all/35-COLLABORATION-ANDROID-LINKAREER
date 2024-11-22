package org.sopt.linkareer.feature.certification.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography

@Composable
fun CertificationAddImageView(
    @DrawableRes addImage: Int?,
    onAddImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isClicked = remember { mutableStateOf(false) }

    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable {
                    isClicked.value = true
                    onAddImageClick()
                }
                .paint(
                    painterResource(
                        if (isClicked.value && addImage != null) {
                            addImage
                        } else {
                            R.drawable.img_add_image_background
                        },
                    ),
                ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.certification_add_capture),
                style = defaultLINKareerTypography.body14R10,
                color = Gray600,
            )
            Spacer(modifier = Modifier.heightIn(12.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_regist_50),
                contentDescription = null,
                Modifier
                    .clickable { onAddImageClick() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationAddImageViewViePreview() {
    LINKareerAndroidTheme {
        CertificationAddImageView(
            null,
            onAddImageClick = {},
        )
    }
}
