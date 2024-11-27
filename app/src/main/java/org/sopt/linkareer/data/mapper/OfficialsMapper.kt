package org.sopt.linkareer.data.mapper

import org.sopt.linkareer.data.model.response.GetOfficialsResponse
import org.sopt.linkareer.domain.model.OfficialEntity

fun GetOfficialsResponse.Official.toOfficialEntity(): OfficialEntity =
    OfficialEntity(
        id = this.id,
        imageUrl = this.imageUrl,
        title = this.title,
        companyName = this.companyName,
        tag = this.tag,
        views = this.views,
        comments = this.comments,
        dDay = this.dDay,
        isBookmarked = this.isBookmarked,
    )
