package org.sopt.linkareer.domain.repository

import org.sopt.linkareer.domain.model.DummyEntity

interface DummyRepository {
    suspend fun getDummyUserList(page: Int): Result<List<DummyEntity>>
}
