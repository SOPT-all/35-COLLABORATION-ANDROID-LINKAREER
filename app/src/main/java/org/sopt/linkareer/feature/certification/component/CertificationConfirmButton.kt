package org.sopt.linkareer.feature.certification.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray400
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography

@Composable
fun CertificationConfirmButton(
    @StringRes buttonText: Int,
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier =
            modifier
                .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 12.dp),
        onClick = { onClickButton() },
        shape = RoundedCornerShape(8.dp),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = White,
                disabledContentColor = White,
                disabledContainerColor = Gray400,
            ),
    ) {
        Text(
            text = stringResource(buttonText),
            style = defaultLINKareerTypography.body8M13,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationConfirmButtonPreview() {
    LINKareerAndroidTheme {
        CertificationConfirmButton(
            buttonText = R.string.certification_confirm_button,
            onClickButton = {},
            modifier = Modifier,
        )
    }
}
