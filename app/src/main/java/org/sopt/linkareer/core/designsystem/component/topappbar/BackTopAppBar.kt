package org.sopt.linkareer.core.designsystem.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun BackTopAppBar() {
    Row(
        modifier =
            Modifier
                .background(color = White)
                .fillMaxWidth()
                .padding(17.dp, 10.dp, 8.dp, 11.dp),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_24),
            contentDescription = null,
            modifier =
                Modifier.clickable {
                    // Todo : 뒤로 가기 구현
                },
        )
    }
}

@Preview
@Composable
fun BackTopAppBarPreview() {
    LINKareerAndroidTheme {
        BackTopAppBar()
    }
}
