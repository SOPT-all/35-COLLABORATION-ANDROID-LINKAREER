package org.sopt.linkareer.domain.repository

import org.sopt.linkareer.domain.model.ChatListEntity

interface ChatRepository {
    suspend fun getChatList(): Result<ChatListEntity>
}
