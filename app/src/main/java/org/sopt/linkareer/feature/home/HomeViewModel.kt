package org.sopt.linkareer.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.sopt.linkareer.R
import org.sopt.linkareer.domain.model.BannerEntity
import org.sopt.linkareer.domain.model.OfficialEntity
import org.sopt.linkareer.domain.model.PostEntity
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
        private set
}

fun getPostList(): List<PostEntity> =
    listOf(
        PostEntity(
            id = 1,
            community = "면접 합격 후기",
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "하나은행 2차 면접 합격 후기입니다",
            content = "우선 대기실에 도착하면 안내 분들께서 친절히 자리를...",
            writer = "문과출신",
            beforeTime = "2시간 전",
            favourites = 384,
            comments = 64,
            views = 6546,
        ),
        PostEntity(
            id = 2,
            community = "자유 이야기방",
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "라인 1차 합격 했는데 고민 되네요...",
            content = "막상 합격하니 얼떨떨 하기도 하고 제가 과연 면접을 잘...",
            writer = "파란사과",
            beforeTime = "2시간 전",
            favourites = 106,
            comments = 76,
            views = 3485,
        ),
        PostEntity(
            id = 3,
            community = "인턴 고민",
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "농협이랑 다른 대기업 둘 중 어딜 선택해야 할...",
            content = "농협 면접 볼 때까지만 해도 붙으면 무조건 가려고 했는데...",
            writer = "surf",
            beforeTime = "1시간 전",
            favourites = 45,
            comments = 2,
            views = 1294,
        ),
    )

fun getOfficialList(): List<OfficialEntity> =
    listOf(
        OfficialEntity(
            id = 1,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 2,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 3,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 4,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 5,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
        OfficialEntity(
            id = 6,
            imageUrl = "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-before-qa1.png",
            title = "[LG CNS][인턴_학사] 2025년 동계 DX Core 인턴 어쩌구 ..",
            companyName = "LG CNS",
            tag = "정규직 1차 면접 프리패스",
            views = 20481,
            comments = 342,
            dDay = "D-7",
            isBookmarked = true,
        ),
    )

fun getBannerList(): List<BannerEntity> =
    listOf(
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_1,
            title = "SYNC 아카데미 6기 모집 (~11/18(월) 오전 11시 부터 모집 시작",
            companyName = "SAP Korea",
            tag = "1차 서류 프리패스",
            views = 2814,
            comments = 0,
            dDay = "D-14",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_2,
            title = "2025년 Sunny School 4기 모집",
            companyName = "행복나눔재단",
            tag = "활동기간 연구실 제공",
            views = 9894,
            comments = 16,
            dDay = "D-10",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_3,
            title = "제3회 대한민국 디지털 인재 양성 프로젝트 IT;s DGB, iM Challenger",
            companyName = "IT;s DGB, IM Challenger",
            tag = "수상자 미국 글로벌 기업 견학",
            views = 344,
            comments = 0,
            dDay = "D-38",
            isBookmarked = false,
        ),
        BannerEntity(
            bannerImage = R.drawable.img_mainbanner_4,
            title = "2024년 하반기 SK하이닉스 청년 Hy-Five 12기 모집 (~12/19)",
            companyName = "SK하이닉스 청년 Hy-Five",
            tag = "정규직 채용 연계",
            views = 9007,
            comments = 2,
            dDay = "D-35",
            isBookmarked = false,
        ),
    )
