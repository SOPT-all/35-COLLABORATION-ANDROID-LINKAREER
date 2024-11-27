package org.sopt.linkareer.core.designsystem.component.tapbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.Blue
import org.sopt.linkareer.core.designsystem.theme.Gray900
import org.sopt.linkareer.core.designsystem.theme.LINKareerAndroidTheme
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme
import org.sopt.linkareer.core.designsystem.theme.White

@Composable
fun InternTapBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(White)
                .padding(start = 17.dp, end = 120.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        InternTabItem(
            tapName = stringResource(R.string.newbie_tab_home),
        )
        Spacer(modifier = Modifier.padding(start = 16.dp))

        InternTabItem(
            tapName = stringResource(R.string.newbie_tab_intern),
        )
        Spacer(modifier = Modifier.padding(start = 16.dp))

        InternTabItem(
            tapName = stringResource(R.string.newbie_tab_newbie),
        )
        Spacer(modifier = Modifier.padding(start = 16.dp))

        InternTabItem(
            tapName = stringResource(R.string.newbie_tab_calendar),
        )
    }
}

@Composable
fun InternTabItem(
    tapName: String,
) {
    Box(
        modifier =
            Modifier
                .width(IntrinsicSize.Max),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = tapName,
            style = LINKareerTheme.typography.body7M14,
            color = if (tapName == stringResource(R.string.newbie_tab_home)) Blue else Gray900,
            modifier =
                Modifier
                    .padding(vertical = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InternTapBarPreview() {
    LINKareerAndroidTheme {
        InternTapBar()
    }
}
