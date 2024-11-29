package org.sopt.linkareer.domain.model

data class PassGuideEntity(
    val id: Int,
    val companyImg: Int,
    val companyName: String,
    val personalStatementNum: Int,
    val personalityNum: Int,
    val interviewNum: Int,
    val finalPassNum: Int,
)
