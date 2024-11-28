package org.sopt.linkareer.feature.certification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray700
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.feature.certification.component.CertificationConfirmButton
import org.sopt.linkareer.feature.certification.component.CertificationTopBar

@Composable
fun CertificationCheckSuccessRoute(
    navigateToChattingRoom: () -> Unit,
) {
    CertificationCheckSuccessScreen(
        navigateToChattingRoom = navigateToChattingRoom
    )
}

@Composable
fun CertificationCheckSuccessScreen(
    navigateToChattingRoom: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(White),
    ) {
        CertificationTopBar(
            onIconClick = {},
            modifier =
                Modifier
                    .padding(top = 27.dp),
        )
        Text(
            text = stringResource(R.string.certification_check_title),
            style = LINKareerTheme.typography.title3B16,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 16.dp),
        )
        Text(
            text = stringResource(R.string.certification_check_subtitle),
            style = LINKareerTheme.typography.body10M11,
            color = Gray700,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 8.dp),
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_check_circle_144),
            contentDescription = stringResource(R.string.certification_check_success),
            modifier =
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 147.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        CertificationConfirmButton(
            buttonText = R.string.certification_confirm_button,
            onClickButton = navigateToChattingRoom,
            isEnabled = true,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(bottom = 32.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationCheckSuccessScreenPreview() {
    LINKareerAndroidTheme {
        CertificationCheckSuccessScreen(
            navigateToChattingRoom = {}
        )
    }
}
