package org.sopt.linkareer.domain.usecase

import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.domain.repository.ChatRepository

class GetChatListUseCase(
    private val chatRepository: ChatRepository,
) {
    suspend operator fun invoke(): Result<ChatListEntity> =
        chatRepository.getChatList()
}
