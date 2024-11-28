package org.sopt.linkareer.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPostsResponse(
    @SerialName("posts")
    val posts: List<Post>,
) {
    @Serializable
    data class Post(
        @SerialName("id")
        val id: Int,
        @SerialName("job")
        val job: String,
        @SerialName("community")
        val community: String,
        @SerialName("imageUrl")
        val imageUrl: String,
        @SerialName("title")
        val title: String,
        @SerialName("content")
        val content: String,
        @SerialName("writer")
        val writer: String,
        @SerialName("beforeTime")
        val beforeTime: String,
        @SerialName("favorites")
        val favourites: Int,
        @SerialName("comments")
        val comments: Int,
        @SerialName("views")
        val views: Int,
    )
}
