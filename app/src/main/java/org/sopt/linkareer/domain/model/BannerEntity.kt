package org.sopt.linkareer.domain.model

data class BannerEntity(
    val bannerImage: Int,
    val title: String,
    val companyName: String,
    val tag: String,
    val views: Int,
    val comments: Int,
    val dDay: String,
    val isBookmarked: Boolean,
)
