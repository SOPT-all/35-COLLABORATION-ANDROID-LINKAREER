package org.sopt.linkareer.data.repositoryimpl

import org.sopt.linkareer.data.datasource.DummyRemoteDataSource
import org.sopt.linkareer.data.model.response.GetDummyUserListResponse
import org.sopt.linkareer.domain.model.DummyEntity
import org.sopt.linkareer.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyRemoteDataSource: DummyRemoteDataSource,
) : DummyRepository {
    override suspend fun getDummyUserList(page: Int): Result<List<DummyEntity>> =
        runCatching {
            dummyRemoteDataSource.getDummyUserList(page = page).data.map { user: GetDummyUserListResponse.User -> user.toDummyEntity() }
        }
}
