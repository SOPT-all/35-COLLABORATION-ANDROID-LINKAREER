package org.sopt.linkareer.data.model.usecase

import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.domain.repository.ChatRepository

class GetChatListUseCase(
    private val chatRepository: ChatRepository,
) {
    suspend operator fun invoke(): Result<ChatListEntity> =
        chatRepository.getChatList()
}
