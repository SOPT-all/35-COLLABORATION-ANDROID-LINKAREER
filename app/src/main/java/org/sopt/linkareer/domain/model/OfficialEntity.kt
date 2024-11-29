package org.sopt.linkareer.domain.model

data class OfficialEntity(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val companyName: String,
    val tag: String,
    val views: Int,
    val comments: Int,
    val dDay: String,
    var isBookmarked: Boolean,
)
