package org.sopt.linkareer.data.datasourceimpl

import org.sopt.linkareer.data.datasource.HomeRemoteDataSource
import org.sopt.linkareer.data.model.response.GetPostsResponse
import org.sopt.linkareer.data.service.HomeService
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val homeService: HomeService,
) : HomeRemoteDataSource {
    override suspend fun getPosts(category: String): GetPostsResponse = homeService.getPosts(category)
}
