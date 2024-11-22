package org.sopt.linkareer.core.designsystem.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun BackTopAppBar(
    onBackButtonClick: () -> Unit,
    appBarAdditionContent: @Composable RowScope.() -> Unit = {},
) {
    Row(
        modifier =
            Modifier
                .background(color = White)
                .fillMaxWidth()
                .padding(start = 17.dp, top = 10.dp, end = 8.dp, bottom = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_24),
            contentDescription = null,
            modifier =
                Modifier.clickable {
                    onBackButtonClick()
                },
        )
        appBarAdditionContent()
    }
}

@Preview
@Composable
fun BackTopAppBarPreview() {
    LINKareerAndroidTheme {
        BackTopAppBar(
            onBackButtonClick = {},
        )
    }
}
