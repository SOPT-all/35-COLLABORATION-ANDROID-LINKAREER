package org.sopt.linkareer.feature.chattinghome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.R
import org.sopt.linkareer.core.designsystem.component.chip.FilteringChip
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun ChattingHomeTabRow(
    currentSelected: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        items(
            count = chattingHomeTabText.size,
            key = { chattingHomeTabText[it] },
        ) { tabText ->
            FilteringChip(
                text = stringResource(chattingHomeTabText[tabText]),
                isSelected = tabText == currentSelected,
                modifier = Modifier.noRippleClickable { onClick(tabText) },
            )
        }
    }
}

private val chattingHomeTabText =
    listOf(
        R.string.chatting_home_all,
        R.string.chatting_home_employment,
        R.string.chatting_home_activities,
        R.string.chatting_home_education,
        R.string.chatting_home_category,
        R.string.chatting_home_subject,
    )
