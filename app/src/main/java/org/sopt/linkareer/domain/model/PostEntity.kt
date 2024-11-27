package org.sopt.linkareer.domain.model

data class PostEntity(
    val id: Int,
    val community: String,
    val imageUrl: String,
    val title: String,
    val content: String,
    val writer: String,
    val beforeTime: String,
    val favourites: Int,
    val comments: Int,
    val views: Int,
)
