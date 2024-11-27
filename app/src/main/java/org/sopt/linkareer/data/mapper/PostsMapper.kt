package org.sopt.linkareer.data.mapper

import org.sopt.linkareer.data.model.response.GetPostsResponse
import org.sopt.linkareer.domain.model.PostEntity

fun GetPostsResponse.Post.toPostEntity(): PostEntity =
    PostEntity(
        id = this.id,
        community = this.community,
        imageUrl = this.imageUrl,
        title = this.title,
        content = this.content,
        writer = this.writer,
        beforeTime = this.beforeTime,
        favourites = this.favourites,
        comments = this.comments,
        views = this.views,
    )
