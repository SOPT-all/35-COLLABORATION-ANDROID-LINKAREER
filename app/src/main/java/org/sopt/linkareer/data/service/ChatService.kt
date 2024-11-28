package org.sopt.linkareer.data.service

import org.sopt.linkareer.data.model.response.ChatListResponse
import retrofit2.http.GET

interface ChatService {
    @GET("api/v1/chatting/history")
    suspend fun getChatList(): ChatListResponse
}
