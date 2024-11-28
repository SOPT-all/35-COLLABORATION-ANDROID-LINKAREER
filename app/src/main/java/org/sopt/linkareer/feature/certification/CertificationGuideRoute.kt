package org.sopt.linkareer.feature.certification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography
import org.sopt.linkareer.feature.certification.component.CertificationConfirmButton
import org.sopt.linkareer.feature.certification.component.CertificationGuideList
import org.sopt.linkareer.feature.certification.component.CertificationTopBar

@Composable
fun CertificationGuideRoute(
    navigateToCertificationEnterInformation: () -> Unit
) {
    CertificationGuideScreen(
        navigateToCertificationEnterInformation = navigateToCertificationEnterInformation
    )
}

@Composable
fun CertificationGuideScreen(
    navigateToCertificationEnterInformation: () -> Unit
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
            text = stringResource(R.string.certification_guide_title),
            style = defaultLINKareerTypography.title3B16,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 16.dp),
        )
        CertificationGuideList(
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(top = 32.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        CertificationConfirmButton(
            buttonText = R.string.certification_ok_button,
            onClickButton = navigateToCertificationEnterInformation,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(bottom = 32.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationGuideScreenPreview() {
    CertificationGuideScreen(
        navigateToCertificationEnterInformation = {}
    )
}
