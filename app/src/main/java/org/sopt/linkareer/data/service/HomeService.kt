package org.sopt.linkareer.data.service

import org.sopt.linkareer.data.model.response.AddBookmarkResponse
import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.data.model.response.GetPostsResponse
import org.sopt.linkareer.data.model.response.RemoveBookmarkResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
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

    @POST("/api/v1/bookmark/{officialId}")
    suspend fun addBookmark(
        @Path("officialId") officialId: Int,
    ): AddBookmarkResponse

    @DELETE("/api/v1/bookmark/{officialId}")
    suspend fun removeBookmark(
        @Path("officialId") officialId: Int,
    ): RemoveBookmarkResponse
}
