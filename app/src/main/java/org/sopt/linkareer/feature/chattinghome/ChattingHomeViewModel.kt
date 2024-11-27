package org.sopt.linkareer.feature.chattinghome

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChattingHomeViewModel @Inject constructor() : ViewModel() {
    var chattingHomeState: MutableStateFlow<ChattingHomeState> = MutableStateFlow(ChattingHomeState())
        private set

    fun updateSearchText(searchText: String) {
        chattingHomeState.update {
            it.copy(
                searchText = searchText,
            )
        }
    }

    fun updateIsMyChattingRoom(isMyChattingRoom: Boolean) {
        chattingHomeState.update {
            it.copy(
                isMyChattingRoom = isMyChattingRoom,
            )
        }
    }

    fun updateChattingRoomTab(chattingRoomTab: Int) {
        chattingHomeState.update {
            it.copy(
                chattingRoomTab = chattingRoomTab,
            )
        }
    }
}
