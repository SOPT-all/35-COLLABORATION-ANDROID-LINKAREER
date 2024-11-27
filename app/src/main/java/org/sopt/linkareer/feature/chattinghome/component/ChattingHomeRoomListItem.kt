package org.sopt.linkareer.feature.chattinghome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.linkareer.core.designsystem.component.chattingroom.ChattingRoomInPerson
import org.sopt.linkareer.domain.model.ChattingRoomEntity

@Composable
fun ChattingHomeRoomListItem(
    roomList: List<ChattingRoomEntity>,
    onClick: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 15.dp),
    ) {
        items(
            count = roomList.size,
            key = { roomList[it].id },
        ) { room ->
            with(roomList[room]) {
                ChattingRoomInPerson(
                    image = companyImage,
                    categories = categories,
                    company = company,
                    chattingTitle = title,
                    participationPerson = participation,
                    onClick = onClick,
                    isInPersonConversation = isInPerson,
                )
            }
        }
    }
}
