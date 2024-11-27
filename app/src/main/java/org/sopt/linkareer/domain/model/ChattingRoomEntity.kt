package org.sopt.linkareer.domain.model

import org.sopt.linkareer.R

data class ChattingRoomEntity(
    val id: Int,
    val companyImage: Int,
    val company: String,
    val title: String,
    val participation: Int,
    val categories: List<String>,
    val isInPerson: Boolean,
)

fun getChattingRoomList(): List<ChattingRoomEntity> =
    listOf(
        ChattingRoomEntity(
            id = 1,
            companyImage = R.drawable.img_chattingroom_inperson_lgcns_70,
            company = "LG CNS",
            title = "[LG CNS] 2025년 동계 체험형 인턴 채용",
            participation = 12947,
            categories = listOf("채용", "LG 이야기방", "현직 멘토 질문방"),
            isInPerson = true,
        ),
        ChattingRoomEntity(
            id = 2,
            companyImage = R.drawable.img_chattingroom_inperson_samsung_70,
            company = "삼성전자",
            title = "[삼성전자] 2025년 상반기 체험형 인턴 채용",
            participation = 9534,
            categories = listOf("채용", "삼성 이야기방", "현직 멘토 질문방"),
            isInPerson = true,
        ),
        ChattingRoomEntity(
            id = 3,
            companyImage = R.drawable.img_chattingroom_inperson_amore_70,
            company = "AMORE PACIFIC",
            title = "[AMORE PACIFIC] 2025년 동계 체험형 인턴 채용",
            participation = 7464,
            categories = listOf("인턴 talk", "현직 멘토 질문방"),
            isInPerson = true,
        ),
        ChattingRoomEntity(
            id = 4,
            companyImage = R.drawable.img_chattingroom_inperson_lgcns_70,
            company = "LG CNS",
            title = "[LG CNS] 2025년 동계 체험형 인턴 채용",
            participation = 12947,
            categories = listOf("채용", "LG 이야기방", "현직 멘토 질문방"),
            isInPerson = true,
        ),
        ChattingRoomEntity(
            id = 5,
            companyImage = R.drawable.img_chattingroom_inperson_samsung_70,
            company = "삼성전자",
            title = "[삼성전자] 2025년 상반기 체험형 인턴 채용",
            participation = 9534,
            categories = listOf("채용", "삼성 이야기방", "현직 멘토 질문방"),
            isInPerson = true,
        ),
        ChattingRoomEntity(
            id = 6,
            companyImage = R.drawable.img_chattingroom_inperson_amore_70,
            company = "AMORE PACIFIC",
            title = "[AMORE PACIFIC] 2025년 동계 체험형 인턴 채용",
            participation = 7464,
            categories = listOf("인턴 talk", "현직 멘토 질문방"),
            isInPerson = true,
        ),
    )
