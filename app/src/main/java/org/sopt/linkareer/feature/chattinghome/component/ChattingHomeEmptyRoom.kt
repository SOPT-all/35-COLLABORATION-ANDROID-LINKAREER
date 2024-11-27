package org.sopt.linkareer.feature.chattinghome.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.theme.LINKareerTheme

@Composable
fun ChattingHomeEmptyRoom(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            Modifier
                .then(modifier)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(LINKareerTheme.colors.blue50)
                .padding(8.dp),
    ) {
        Text(
            text = stringResource(R.string.chatting_home_room_empty),
            style = LINKareerTheme.typography.body10M11,
            color = LINKareerTheme.colors.gray800,
        )
        Text(
            text = stringResource(R.string.chatting_home_enter_room),
            style = LINKareerTheme.typography.body10M11,
            color = LINKareerTheme.colors.blue,
        )
    }
}
