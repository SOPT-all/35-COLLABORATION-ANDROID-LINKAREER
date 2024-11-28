package org.sopt.linkareer.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetOfficialsResponse(
    @SerialName("officialList")
    val officialList: List<Official>,
) {
    @Serializable
    data class Official(
        @SerialName("id")
        val id: Int,
        @SerialName("interestJob")
        val interestJob: String,
        @SerialName("imageUrl")
        val imageUrl: String,
        @SerialName("title")
        val title: String,
        @SerialName("companyName")
        val companyName: String,
        @SerialName("tag")
        val tag: String,
        @SerialName("comments")
        val comments: Int,
        @SerialName("views")
        val views: Int,
        @SerialName("dday")
        val dDay: String,
        @SerialName("bookmark")
        val isBookmarked: Boolean,
    )
}
