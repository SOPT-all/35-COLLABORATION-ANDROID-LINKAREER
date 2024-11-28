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
import org.sopt.linkareer.core.designsystem.component.textfield.CertificationTextField
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography
import org.sopt.linkareer.feature.certification.component.CertificationAddImageBox
import org.sopt.linkareer.feature.certification.component.CertificationConfirmButton
import org.sopt.linkareer.feature.certification.component.CertificationTopBar

@Composable
fun CertificationEnterInformationRoute() {
    CertificationEnterInformationScreen()
}

@Composable
fun CertificationEnterInformationScreen() {
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
            text = stringResource(R.string.certification_write_title),
            style = defaultLINKareerTypography.title3B16,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 16.dp),
        )

        Text(
            text = stringResource(R.string.certification_name_field),
            style = defaultLINKareerTypography.body4B12,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 32.dp),
        )
        CertificationTextField(
            value = "",
            onValueChange = {},
            hintText = stringResource(R.string.certification_name_placeholder),
            helperMessage = "",
            showHelperMessage = false,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(top = 12.dp),
        )

        Text(
            text = stringResource(R.string.certification_phone_field),
            style = defaultLINKareerTypography.body4B12,
            color = Gray900,
            modifier =
                Modifier
                    .padding(start = 17.dp, top = 32.dp),
        )
        CertificationTextField(
            value = "",
            onValueChange = {},
            hintText = stringResource(R.string.certification_phone_placeholder),
            helperMessage = "",
            showHelperMessage = false,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(top = 12.dp),
        )

        Text(
            text = stringResource(R.string.certification_capture_field),
            style = defaultLINKareerTypography.body4B12,
            color = Gray900,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(top = 32.dp),
        )
        Text(
            text = stringResource(R.string.certification_write_capture_desc),
            style = defaultLINKareerTypography.label4M10,
            color = Gray600,
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(top = 4.dp),
        )
        CertificationAddImageBox(
            addImage = R.drawable.img_chatting_validation,
            modifier =
                Modifier
                    .padding(top = 12.dp),
        )

        Spacer(modifier = Modifier.weight(1f))
        CertificationConfirmButton(
            buttonText = R.string.certification_confirm_button,
            onClickButton = {},
            modifier =
                Modifier
                    .padding(horizontal = 17.dp)
                    .padding(bottom = 32.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationEnterInformationScreenPreview() {
    LINKareerAndroidTheme {
        CertificationEnterInformationScreen()
    }
}
