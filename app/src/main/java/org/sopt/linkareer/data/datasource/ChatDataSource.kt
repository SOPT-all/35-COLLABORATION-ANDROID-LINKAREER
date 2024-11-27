package org.sopt.linkareer.data.datasource

import org.sopt.linkareer.data.model.response.ChatListResponse

interface ChatDataSource {
    suspend fun getChatList() : ChatListResponse
}