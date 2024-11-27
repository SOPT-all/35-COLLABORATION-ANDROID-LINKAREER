package org.sopt.linkareer.feature.home

import org.sopt.linkareer.domain.model.BannerEntity
import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.model.PostEntity

data class HomeState(
    val bannerList: List<BannerEntity> = getBannerList(),
    val postList: List<PostEntity> = getPostList(),
    val officialList: List<OfficialEntity> = getOfficialList(),
)
