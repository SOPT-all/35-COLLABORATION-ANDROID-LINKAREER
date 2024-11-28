package org.sopt.linkareer.feature.chattingroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.usecase.GetChatListUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val getChatListUseCase: GetChatListUseCase,
) : ViewModel() {
    var chatRoomState: MutableStateFlow<UiState<ChatRoomState>> = MutableStateFlow<UiState<ChatRoomState>>(UiState.Empty)
        private set

    fun getChatList() {
        chatRoomState.value = UiState.Loading
        viewModelScope.launch {
            getChatListUseCase().fold(
                onSuccess = { chatListEntity ->
                    chatRoomState.value =
                        UiState.Success(
                            ChatRoomState(chatListEntity = chatListEntity),
                        )
                    Timber.tag("ChatRoomViewModel").d("성공 : $chatListEntity")
                },
                onFailure = {
                    chatRoomState.value =
                        UiState.Failure(
                            msg = it.message.toString(),
                        )
                    Timber.tag("ChatRoomViewModel").d("실패 : ${it.message}")
                },
            )
        }
    }
}
