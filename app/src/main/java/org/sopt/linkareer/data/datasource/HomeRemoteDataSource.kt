package org.sopt.linkareer.data.datasource

import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.data.model.response.GetPostsResponse

interface HomeRemoteDataSource {
    suspend fun getPosts(category: String): GetPostsResponse

    suspend fun getOfficials(category: String): GetOfficialsResponse
}
