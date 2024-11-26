package org.sopt.linkareer.feature.chattinghome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.linkareer.core.extension.noRippleClickable

@Composable
fun ChattingHomeRoute(
    paddingValues: PaddingValues,
    navigateToChattingRoom: () -> Unit,
) {
    ChattingHomeScreen(
        paddingValues,
        navigateToChattingRoom,
    )
}

@Composable
fun ChattingHomeScreen(
    paddingValues: PaddingValues,
    navigateToChattingRoom: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(paddingValues),
    ) {
        Text(
            "ChattingHome",
            modifier = Modifier.noRippleClickable { navigateToChattingRoom() },
        )
    }
}
