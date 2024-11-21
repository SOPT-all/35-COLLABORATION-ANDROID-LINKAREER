package org.sopt.linkareer.core.designsystem.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import okhttp3.internal.immutableListOf
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme

@Composable
fun LogoTopAppBar() {
    Row(
        modifier =
            Modifier
                .background(color = Blue)
                .fillMaxWidth()
                .padding(9.dp, 6.dp, 9.dp, 6.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_logo),
            contentDescription = null,
        )
        TopAppBarIconRow(iconList = logoTopAppBarIcons)
    }
}

val logoTopAppBarIcons =
    immutableListOf(
        R.drawable.ic_calendar_white_36,
        R.drawable.ic_notice_white_36,
        R.drawable.ic_bookmark_white_36,
        R.drawable.ic_chatting_default_36,
    )

@Preview
@Composable
fun LogoTopAppBarPreview() {
    LINKareerAndroidTheme {
        LogoTopAppBar()
    }
}
