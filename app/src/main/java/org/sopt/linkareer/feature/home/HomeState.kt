package org.sopt.linkareer.feature.home

import org.sopt.linkareer.domain.model.BannerEntity

data class HomeState(
    val bannerList: List<BannerEntity> = listOf(),
)
