package org.sopt.linkareer.data.datasourceimpl

import org.sopt.linkareer.data.datasource.DummyRemoteDataSource
import org.sopt.linkareer.data.model.response.GetDummyUserListResponse
import org.sopt.linkareer.data.service.DummyService
import javax.inject.Inject

class DummyRemoteDataSourceImpl @Inject constructor(
    private val dummyService: DummyService,
) : DummyRemoteDataSource {
    override suspend fun getDummyUserList(page: Int): GetDummyUserListResponse = dummyService.getDummyListUserList(page = page)
}
