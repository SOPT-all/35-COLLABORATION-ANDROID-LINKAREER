package org.sopt.linkareer.core.designsystem.component.tapbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.White
import org.sopt.linkareer.core.designsystem.theme.defaultLINKareerTypography

@Composable
fun HomeTapBar(
    onTabClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val newbieTab = stringResource(R.string.home_tab_newbie)
    var rememberTap by remember { mutableStateOf<String?>(null) }

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(White)
                .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TabItem(
            tapName = newbieTab,
            isSelected = rememberTap == newbieTab,
            onClick = {
                rememberTap = newbieTab
                onTabClick(newbieTab)
            },
        )
        Spacer(modifier = Modifier.padding(start = 12.dp))

        TabItem(
            tapName = stringResource(R.string.home_tab_contest),
            isSelected = false,
        )
        Spacer(modifier = Modifier.padding(start = 12.dp))

        TabItem(
            tapName = stringResource(R.string.home_tab_channel),
            isSelected = false,
        )
        Spacer(modifier = Modifier.padding(start = 12.dp))

        TabItem(
            tapName = stringResource(R.string.home_tab_community),
            isSelected = false,
        )

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_box_30),
            contentDescription = stringResource(R.string.newbie_tab_arrow_down_contentDescription),
        )
    }
}

@Composable
fun TabItem(
    tapName: String,
    isSelected: Boolean,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier =
            Modifier
                .clickable { if (onClick != null) onClick() }
                .width(IntrinsicSize.Max)
                .drawBehind {
                    if (isSelected) {
                        drawLine(
                            color = Blue,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 2.dp.toPx(),
                        )
                    }
                },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = tapName,
            style = defaultLINKareerTypography.title5B14,
            color = if (isSelected) Blue else Gray900,
            modifier =
                Modifier
                    .padding(vertical = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTapBarPreview() {
    LINKareerAndroidTheme {
        HomeTapBar(
            onTabClick = {},
        )
    }
}
