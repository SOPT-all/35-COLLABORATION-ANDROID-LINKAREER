package org.sopt.linkareer.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddBookmarkResponse(
    @SerialName("message")
    val message: String,
)
