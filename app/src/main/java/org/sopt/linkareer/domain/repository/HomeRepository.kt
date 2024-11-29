package org.sopt.linkareer.domain.repository

import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.model.PostEntity

interface HomeRepository {
    suspend fun getPosts(category: String): Result<List<PostEntity>>

    suspend fun getOfficials(category: String): Result<List<OfficialEntity>>

    suspend fun addBookmark(
        officialId: Int,
        memberId: Int,
    ): Result<String>

    suspend fun removeBookmark(
        officialId: Int,
        memberId: Int,
    ): Result<String>
}
