package org.sopt.linkareer.feature.newbieintern

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.sopt.linkareer.R
import org.sopt.linkareer.domain.model.PassGuideEntity
import org.sopt.linkareer.domain.model.RoadMapEntity
import javax.inject.Inject

@HiltViewModel
class NewbieInternViewModel @Inject constructor() : ViewModel() {
    var newbieInternState: MutableStateFlow<NewbieInternState> =
        MutableStateFlow(
            NewbieInternState(),
        )
        private set
}

fun getRoadMapList(): List<RoadMapEntity> =
    listOf(
        RoadMapEntity(
            subTitle = "합격을 위한 꿀팁과 전략",
            mainTitle = "인/적성\n합격후기",
            image = R.drawable.img_newbie_personalitypass,
        ),
        RoadMapEntity(
            subTitle = "면접장에서 빛난 전략",
            mainTitle = "면접\n합격후기",
            image = R.drawable.img_newbie_interviewpass,
        ),
        RoadMapEntity(
            subTitle = "최종합격까지의 여정",
            mainTitle = "최종\n합격후기",
            image = R.drawable.img_newbie_finalpass,
        ),
        RoadMapEntity(
            subTitle = "문과 맞춤형 취업 멘토링",
            mainTitle = "문과\n멘토 질문방",
            image = R.drawable.img_newbie_liberalartsmentor,
        ),
        RoadMapEntity(
            subTitle = "이과 맞춤형 취업 멘토링",
            mainTitle = "이과\n멘토 질문방",
            image = R.drawable.img_newbie_sciencementor,
        ),
        RoadMapEntity(
            subTitle = "가장 궁금해 한 Q&A",
            mainTitle = "BEST Q&A",
            image = R.drawable.img_newbie_qna,
        ),
    )

fun getPassGuideList(): List<PassGuideEntity> =
    listOf(
        PassGuideEntity(
            id = 1,
            companyImg = R.drawable.img_companypass_samsung_54,
            companyName = "삼성전자",
            personalStatementNum = 0,
            personalityNum = 0,
            interviewNum = 0,
            finalPassNum = 0,
        ),
        PassGuideEntity(
            id = 2,
            companyImg = R.drawable.img_chattingroom_inperson_lgcns_70,
            companyName = "LG CNS",
            personalStatementNum = 0,
            personalityNum = 0,
            interviewNum = 0,
            finalPassNum = 0,
        ),
        PassGuideEntity(
            id = 3,
            companyImg = R.drawable.img_chattingroom_inperson_amore_70,
            companyName = "AMORE PACIFIC",
            personalStatementNum = 0,
            personalityNum = 0,
            interviewNum = 0,
            finalPassNum = 0,
        ),
    )
