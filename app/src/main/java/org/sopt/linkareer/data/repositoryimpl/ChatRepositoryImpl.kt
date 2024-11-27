package org.sopt.linkareer.data.repositoryimpl

import org.sopt.linkareer.data.datasource.ChatDataSource
import org.sopt.linkareer.domain.model.ChatListEntity
import org.sopt.linkareer.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatDataSource: ChatDataSource
) : ChatRepository {
    override suspend fun getChatList(): Result<ChatListEntity> =
        runCatching {
            chatDataSource.getChatList().chatListResponseToEntity()
        }
}