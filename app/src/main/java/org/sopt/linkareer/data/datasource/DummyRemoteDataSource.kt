package org.sopt.linkareer.data.datasource

import org.sopt.linkareer.data.model.response.GetDummyUserListResponse

interface DummyRemoteDataSource {
    suspend fun getDummyUserList(page: Int): GetDummyUserListResponse
}
