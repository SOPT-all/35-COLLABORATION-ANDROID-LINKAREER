package org.sopt.linkareer.data.repositoryimpl

import org.sopt.linkareer.data.datasource.HomeRemoteDataSource
import org.sopt.linkareer.data.mapper.toPostEntity
import org.sopt.linkareer.domain.model.PostEntity
import org.sopt.linkareer.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource,
) : HomeRepository {
    override suspend fun getPosts(category: String): Result<List<PostEntity>> =
        runCatching {
            homeRemoteDataSource.getPosts(category).posts.map {
                it.toPostEntity()
            }
        }
}
