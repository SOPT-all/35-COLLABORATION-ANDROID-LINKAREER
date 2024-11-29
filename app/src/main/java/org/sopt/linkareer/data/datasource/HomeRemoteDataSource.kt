package org.sopt.linkareer.data.datasource

import org.sopt.linkareer.data.model.response.AddBookmarkResponse
import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.data.model.response.GetPostsResponse
import org.sopt.linkareer.data.model.response.RemoveBookmarkResponse

interface HomeRemoteDataSource {
    suspend fun getPosts(category: String): GetPostsResponse

    suspend fun getOfficials(category: String): GetOfficialsResponse

    suspend fun addBookmark(
        officialId: Int,
    ): AddBookmarkResponse

    suspend fun removeBookmark(
        officialId: Int,
    ): RemoveBookmarkResponse
}
