package org.sopt.linkareer.core.designsystem.component.footer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Black
import org.sopt.linkareer.core.designsystem.theme.Gray400
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun MainFooter(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(68.dp),
            modifier =
                Modifier
                    .padding(top = 9.dp),
        ) {
            FooterText(text = stringResource(R.string.footer_terms_of_use))
            FooterText(text = stringResource(R.string.footer_personal_information_policy))
            FooterText(text = stringResource(R.string.footer_customer_inquiry))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .padding(top = 8.dp, bottom = 27.dp),
        ) {
            Text(
                stringResource(R.string.footer_copyright_1),
                style = LINKareerTheme.typography.body13R11,
                color = Gray400,
            )
            Text(
                stringResource(R.string.footer_copyright_2),
                style = LINKareerTheme.typography.label1B11,
                color = Gray400,
            )
            Text(
                stringResource(R.string.footer_copyright_3),
                style = LINKareerTheme.typography.body13R11,
                color = Gray400,
            )
        }
    }
}

@Composable
fun FooterText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = LINKareerTheme.typography.label3M11,
        color = Black,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun MainFooterPreview() {
    LINKareerAndroidTheme {
        MainFooter()
    }
}
