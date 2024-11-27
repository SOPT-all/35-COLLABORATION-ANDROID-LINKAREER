package org.sopt.linkareer.feature.certification.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Gray100
import org.sopt.linkareer.core.designsystem.theme.Gray600
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun CertificationGuideList(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CertificationGuideItem(
            cardImage = R.drawable.ic_checklist_person_24,
            cardTitle = R.string.certification_name_field,
            cardDescription = R.string.certification_guide_name_description,
            cardContentDescription = R.string.certification_name_content_description,
        )
        CertificationGuideItem(
            cardImage = R.drawable.ic_checklist_phone_24,
            cardTitle = R.string.certification_phone_field,
            cardDescription = R.string.certification_guide_phone_description,
            cardContentDescription = R.string.certification_phone_content_description,
        )
        CertificationGuideItem(
            cardImage = R.drawable.ic_checklist_docu_24,
            cardTitle = R.string.certification_capture_field,
            cardDescription = R.string.certification_guide_capture_description,
            cardContentDescription = R.string.certification_capture_content_description,
        )
    }
}

@Composable
fun CertificationGuideItem(
    @DrawableRes cardImage: Int,
    @StringRes cardTitle: Int,
    @StringRes cardDescription: Int,
    @StringRes cardContentDescription: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Gray100),
    ) {
        Image(
            painter = painterResource(cardImage),
            contentDescription = stringResource(cardContentDescription),
            modifier =
                Modifier
                    .padding(vertical = 24.dp)
                    .padding(start = 20.dp),
        )

        Column(
            modifier =
                Modifier
                    .padding(start = 16.dp),
        ) {
            Text(
                text = stringResource(cardTitle),
                style = LINKareerTheme.typography.body4B12,
                color = Gray900,
            )

            Text(
                text = stringResource(cardDescription),
                style = LINKareerTheme.typography.body11M10,
                color = Gray600,
                modifier =
                    Modifier
                        .padding(top = 4.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CertificationGuideItemPreview() {
    CertificationGuideItem(
        cardImage = R.drawable.ic_checklist_docu_24,
        cardTitle = R.string.certification_name_field,
        cardDescription = R.string.certification_guide_phone_description,
        cardContentDescription = R.string.back_content_description,
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun CertificationGuideListPreview() {
    CertificationGuideList()
}
