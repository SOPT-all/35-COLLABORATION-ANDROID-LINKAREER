package org.sopt.linkareer.data.service

import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.data.model.response.GetPostsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("api/v1/posts")
    suspend fun getPosts(
        @Query("category") category: String,
    ): GetPostsResponse

    @GET("api/v1/officiallist")
    suspend fun getOfficials(
        @Query("category") category: String,
    ): GetOfficialsResponse
}
