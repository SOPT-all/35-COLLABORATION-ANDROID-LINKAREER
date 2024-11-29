package org.sopt.linkareer.feature.certification.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun CertificationAddImageBox(
    @DrawableRes addImage: Int?,
    modifier: Modifier = Modifier,
) {
    var isClicked by remember { mutableStateOf(false) }

    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable {
                    isClicked = true
                }
                .paint(
                    painterResource(
                        if (isClicked && addImage != null) {
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
            if (!isClicked) {
                Text(
                    text = stringResource(R.string.certification_add_capture),
                    style = LINKareerTheme.typography.body14R10,
                    color = Gray600,
                )
                Spacer(modifier = Modifier.heightIn(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_regist_50),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationAddImageBoxPreview() {
    LINKareerAndroidTheme {
        CertificationAddImageBox(
            null,
        )
    }
}
