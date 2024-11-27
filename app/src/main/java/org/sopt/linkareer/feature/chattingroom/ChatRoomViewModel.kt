package org.sopt.linkareer.feature.chattingroom

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.sopt.linkareer.data.model.usecase.GetChatListUseCase
import org.sopt.linkareer.domain.model.ChatListEntity
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val getChatListUseCase: GetChatListUseCase
) : ViewModel() {

}