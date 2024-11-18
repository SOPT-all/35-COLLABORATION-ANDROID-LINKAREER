package org.sopt.linkareer.data.service

import org.sopt.linkareer.data.model.response.GetDummyUserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {
    @GET("api/users")
    suspend fun getDummyListUserList(
        @Query("page") page: Int,
    ): GetDummyUserListResponse
}
