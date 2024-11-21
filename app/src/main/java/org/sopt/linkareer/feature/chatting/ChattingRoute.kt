package org.sopt.linkareer.feature.chatting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChattingRoute(
    paddingValues: PaddingValues,
) {
    ChattingScreen(paddingValues)
}

@Composable
fun ChattingScreen(
    paddingValues: PaddingValues,
) {
    Column(
        modifier =
            Modifier
                .padding(paddingValues),
    ) {
        Text("Chatting")
    }
}
