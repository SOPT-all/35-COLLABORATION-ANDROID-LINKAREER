package org.sopt.linkareer.data.datasourceimpl

import org.sopt.linkareer.data.datasource.ChatDataSource
import org.sopt.linkareer.data.model.response.ChatListResponse
import org.sopt.linkareer.data.service.ChatService
import javax.inject.Inject

class ChatDataSourceImpl @Inject constructor(
    private val chatService: ChatService
) : ChatDataSource {
    override suspend fun getChatList(): ChatListResponse = chatService.getChatList()
}