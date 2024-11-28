package org.sopt.linkareer.feature.home

import org.sopt.linkareer.core.state.UiState
import org.sopt.linkareer.domain.model.BannerEntity
import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.model.PostEntity

data class HomeState(
    val bannerList: List<BannerEntity> = getBannerList(),
    val postList: UiState<List<PostEntity>> = UiState.Loading,
    val officialList: UiState<List<OfficialEntity>> = UiState.Loading,
)
