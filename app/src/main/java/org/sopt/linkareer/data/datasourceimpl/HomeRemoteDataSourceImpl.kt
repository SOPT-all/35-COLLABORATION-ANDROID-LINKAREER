package org.sopt.linkareer.data.datasourceimpl

import org.sopt.linkareer.data.datasource.HomeRemoteDataSource
import org.sopt.linkareer.data.model.response.AddBookmarkResponse
import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.data.model.response.GetPostsResponse
import org.sopt.linkareer.data.model.response.RemoveBookmarkResponse
import org.sopt.linkareer.data.service.HomeService
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val homeService: HomeService,
) : HomeRemoteDataSource {
    override suspend fun getPosts(category: String): GetPostsResponse = homeService.getPosts(category)

    override suspend fun getOfficials(category: String): GetOfficialsResponse = homeService.getOfficials(category)

    override suspend fun addBookmark(
        officialId: Int,
    ): AddBookmarkResponse = homeService.addBookmark(officialId)

    override suspend fun removeBookmark(
        officialId: Int,
    ): RemoveBookmarkResponse = homeService.removeBookmark(officialId = officialId)
}
